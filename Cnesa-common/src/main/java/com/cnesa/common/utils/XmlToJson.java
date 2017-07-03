package com.cnesa.common.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.util.JSONStringer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlToJson {
	public static String generator(String strXML,String strRoot){
		JSONObject jsonObj;
		try {
			InputStream is = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			NodeList node_list = doc.getElementsByTagName(strRoot);

			// update by shpower.lee
			String resultJson = getJson(node_list);
			resultJson = resultJson.replaceAll("\\r", "");
			
			JSON returnJson = JSONSerializer.toJSON("{"+resultJson+"}");

			jsonObj = JSONObject.fromObject(returnJson);
			// jsonObj = (JSONObject)new XMLSerializer().read(strXML);
			return jsonObj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception "+e.getMessage());
			// jsonObj = (JSONObject)new XMLSerializer().read(strXML);
			// return jsonObj;
			return null;
		}
	}
	
	private static void append(StringBuffer sb ,String strData){
		sb.append("\"");
		sb.append(strData.replaceAll("\n", "\\\\n").replaceAll("\"", "\\\\\""));
		sb.append("\"");
	}
	
	private static boolean hasChildNode(Element element){
		NodeList nodeList = element.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				return true;
			}
		}
		return false;
		
	}
	
	private static boolean isCDATANode(Node node){
		NodeList nodeList = node.getChildNodes();
		if (nodeList != null) {
		    for (int i = 0; i < nodeList.getLength(); i++) {
		        Node child = nodeList.item(i);
		        if (child.getNodeType() == Node.CDATA_SECTION_NODE) {
		        	return true;
		        }
		    }
		}
		return false;
	}
	
	/**
	 * CDATA 특수 문자 치환
	 * @param value
	 * @return
	 */
	public static String getCdataString(String value){
		return new JSONStringer().object().key("CDATA").value(value).endObject().toString();
	}
	
	private static String getJson(NodeList nodeList){
		String strJson = "";
		StringBuffer sb = new StringBuffer();
		int n=0;
		boolean isCDATA = false;

		for(int i=0;i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				isCDATA = isCDATANode(node);
				Element element = (Element) node;
				if(n>0)sb.append(",");
				n++;
				append(sb,element.getNodeName());sb.append(":");
				if(element.hasAttributes()){
					NamedNodeMap map = (NamedNodeMap)element.getAttributes();
					sb.append("{");
					for(int j=0;j<map.getLength();j++){
						sb.append(j==0?"":",");append(sb,"@"+map.item(j).getNodeName());sb.append(":");append(sb,map.item(j).getNodeValue());
					}
					if(!hasChildNode(element) && element.getTextContent()!=null && element.getTextContent().length()>0){
						sb.append(",");
						if(isCDATA){
							String result =  getCdataString(element.getTextContent()) ;
							sb.append( result.substring(1,result.length()-1) );
							
							/*
							sb.append("{");
							append(sb,"CDATA");
							sb.append(":");
							append(sb,element.getTextContent());
							sb.append("}");
							*/
						}else{
							append(sb,"#Text");
							sb.append(":");
							append(sb,element.getTextContent());
							// append(sb,element.getTextContent().replaceAll("\r", "").replaceAll("\n", ""));
						}
					}
					if(hasChildNode(element)){
						sb.append(",");
						sb.append(getJson(element.getChildNodes()));
					}
					sb.append("}");
				}else{
					if(!hasChildNode(element)){
						if(isCDATA){
							sb.append( getCdataString(element.getTextContent()) );
							
							/*
							sb.append("{");
							append(sb,"CDATA");
							sb.append(":");
							append(sb,element.getTextContent());
							sb.append("}");
							*/
						}else{
							append(sb,element.getTextContent());
							// append(sb,element.getTextContent().replaceAll("\r", "").replaceAll("\n", ""));
						}
					}else if(hasChildNode(element)){
						sb.append("{");
						sb.append(getJson(element.getChildNodes()));
						sb.append("}");
					}
				}
				//sb.append("\n");
			}
		}
		
		return sb.toString();
	}
	
}

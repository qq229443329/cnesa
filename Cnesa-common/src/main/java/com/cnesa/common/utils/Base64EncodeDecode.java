/**
 * 
 */
package com.cnesa.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author Sang-Hyup Lee
 *
 */
public class Base64EncodeDecode {

    static private Logger log = LoggerFactory.getLogger(Base64EncodeDecode.class);

    /**
     * convert base64 to ASCII
     * 
     * @param encodeBytes
     * @return
     */
    public static String encode(byte[] encodeBytes) {
        byte[] buf = null;
        String strResult = null;

        BASE64Encoder base64Encoder = new BASE64Encoder();
        ByteArrayInputStream bin = new ByteArrayInputStream(encodeBytes);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        try {
            base64Encoder.encodeBuffer(bin, bout);
            buf = bout.toByteArray();
            strResult = new String(buf).trim();
        } catch (IOException e) {
            log.error("encodeBuffer fail");
            e.printStackTrace();
        }
        return strResult;
    }

    /**
     * convert ASCII to base64
     * 
     * @param strDecode
     * @return
     */
    public static byte[] decode(String strDecode) {
        byte[] buf = null;

        BASE64Decoder base64Decoder = new BASE64Decoder();
        ByteArrayInputStream bin = new ByteArrayInputStream(strDecode.getBytes());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        try {
            base64Decoder.decodeBuffer(bin, bout);
        } catch (Exception e) {
            log.error("Exception");
            e.printStackTrace();
        }
        buf = bout.toByteArray();
        return buf;
    }
    
}

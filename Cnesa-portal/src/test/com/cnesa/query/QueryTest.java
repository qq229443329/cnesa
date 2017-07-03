package com.cnesa.query;

import com.cnesa.asset.service.AssetAttributeService;
import com.cnesa.query.common.KairosdbConstant;
import com.cnesa.query.service.KairosdbService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shangpeibao on 16/12/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml", "classpath*:config/ehcache-config.xml"})
public class QueryTest {

    private static final DateFormat df_ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateFormat df_ymd = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    KairosdbService kairosdbService;

    @Autowired
    private AssetAttributeService assetAttributeService;
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Test
    public void testSelectValues() {

        try {
            Date start = df.parse("2016-12-19 14:00:00");
            Date end = df.parse("2016-12-19 14:30:00");
            DecimalFormat dFormat = new DecimalFormat("#.###");
            Map<String, List<JSONObject>> map = kairosdbService.selectValues(start, end, Arrays.asList("DONGBA#BJ#EM_M004#YX#em_status"), "value", "yyyy-MM-dd HH:mm:ss", dFormat, true);
            for (Map.Entry<String, List<JSONObject>> entry : map.entrySet()) {
                System.out.println(entry.getKey());
                List<JSONObject> list = entry.getValue();
                for (JSONObject obj : list) {
                    System.out.println(obj.getString("time") + "____" + obj.get("value"));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void TY(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("8", "test");
        System.out.println(jsonObject.get("8"));
    }

    @Test
    public void testSelectValuesByTimes(){
        try {
            Date startDate = df.parse("2017-03-21 00:00:00");
            Date endDate = df.parse("2017-03-22 23:59:59");
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            Map<String, List<net.sf.json.JSONObject>> datas = kairosdbService.selectValuesByTimes(startDate, endDate, Arrays.asList("DONGBA#BJ#EM_M001#i_a","DONGBA#BJ#EM_P002#u_ab"), KairosdbConstant.TAG_VALUE, "yyyy-MM-dd HH:mm:ss", decimalFormat, true, 1, "hour");
            System.out.println("--");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectMax() throws ParseException, IOException, URISyntaxException {
        Date start = df_ymdhms.parse("2017-04-21 00:00:00");
        Date end = df_ymdhms.parse("2017-04-21 23:59:59");
        List<JSONObject> maxList = kairosdbService.selectMax(start, end, "DONGBA#BJ#EM_M001#forw_act_w", "value", "yyyy-MM-dd HH:mm:ss", new DecimalFormat("#.##"), 1, "day");
        System.out.println(maxList.size());
    }

    @Test
    public void selectLast() throws ParseException, IOException, URISyntaxException {
        Date start = df_ymdhms.parse("2017-06-01 00:00:00");
        Date end = df_ymdhms.parse("2017-06-30 23:59:59");
        List<JSONObject> maxList = kairosdbService.selectLast(start, end, "PEK#LQGC#DB600170060000#Ia", "value", "yyyy-MM-dd HH:mm:ss", new DecimalFormat("#.##"), 1, "day");
        for (JSONObject obj : maxList) {
            System.out.println(obj.get("time") +  "--------" + obj.get("value"));
        }
        System.out.println(maxList.size());
    }
}

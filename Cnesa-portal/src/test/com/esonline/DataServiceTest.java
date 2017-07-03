package com.cnesa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by shangpeibao on 16/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml", "classpath*:config/redis-config.xml", "classpath*:config/ehcache-config.xml"})
public class DataServiceTest {

    @Autowired
    DataService dataService;

    @Test
    public void testSelectRunningPowerRate() {
        List<String> assetIds = Arrays.asList("1ac101bd-db22-4351-9b7d-8b52d43a4d31","064add10-2443-44e0-8589-6fd46884f113");
        String attrCode = "u_b";
        System.out.println(dataService.selectRunningPowerRate(assetIds, attrCode));
    }

    @Test
    public void testSelectPcsMetersByProject() {
        List<Map<String, String>> list = dataService.selectPcsMetersByProject("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
        for (Map<String, String> map : list) {
            System.out.println(map.get("id"));
        }
    }

    @Test
    public void testSelectRunningPCSValue() {
        List<String> assetIds = Arrays.asList("064add10-2443-44e0-8589-6fd46884f113","1ac101bd-db22-4351-9b7d-8b52d43a4d31");
        List<String> attrCodes = Arrays.asList("u_b","u_a");
        Map<String, Double> map = dataService.selectRunningPCSValue(assetIds, attrCodes);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "____" + entry.getValue());
        }
    }

    @Test
    public void testSelectRunningBatteryInfo() {
        List<String> assetIds = Arrays.asList("064add10-2443-44e0-8589-6fd46884f113","1ac101bd-db22-4351-9b7d-8b52d43a4d31");
        List<String> attrCodes = Arrays.asList("bp_soc","bp_rechargeable","bp_redischargeable");
        Map<String, Double> map = dataService.selectRunningBatteryInfo(assetIds, attrCodes);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "____" + entry.getValue());
        }
    }


    @Test
    public void testSelectSystemEfficiency() {
        List<String> assetIds = Arrays.asList("064add10-2443-44e0-8589-6fd46884f113","1ac101bd-db22-4351-9b7d-8b52d43a4d31");
        List<String> attrCodes = Arrays.asList("bp_soc","bp_rechargeable","bp_redischargeable");
        try {
            Map<String, Object> map = dataService.selectSystemEfficiency(assetIds);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "   " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectMonthLoadFactor() {
        try {
            Map<String, Object> map = (Map<String, Object>) dataService.selectMonthLoadFactor("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
            for (Map.Entry<String, Object> m : map.entrySet()) {
                System.out.println(m.getKey() + "   " + m.getValue());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

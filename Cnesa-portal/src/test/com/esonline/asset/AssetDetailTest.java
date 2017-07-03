package com.cnesa.asset;

import com.cnesa.asset.service.AssetDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shangpeibao on 16/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml"})
public class AssetDetailTest {

    @Autowired
    AssetDetailService assetDetailService;

    @Test
    public void testRunningPowerRate() {
        List<String> assetIds = Arrays.asList("1ac101bd-db22-4351-9b7d-8b52d43a4d31","064add10-2443-44e0-8589-6fd46884f113");
        String attrCode = "u_b";
        List<String> list = assetDetailService.selectSolekeyByAssetIdAndAttrCode(assetIds, attrCode);
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testate() {
        String sokey = assetDetailService.selectSolekeyByAssetIdAndAttrCode("e959844e-28a1-11e7-93ae-92361f002671", "EgP_p");
        System.out.println(sokey);
    }
}

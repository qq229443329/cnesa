package com.cnesa.asset;

import com.cnesa.asset.service.AssetAttributeService;
import com.cnesa.common.EhcacheConstant;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by shangpeibao on 16/12/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml", "classpath*:config/ehcache-config.xml"})
public class AssetAttributeTest {

    @Autowired
    CacheManager cacheManager;
    @Autowired
    private AssetAttributeService assetAttributeService;

    @Test
    public void testSelectTranslateByProjectId() {
        assetAttributeService.selectTranslate();
//        Cache cache = cacheManager.getCache(EhcacheConstant.CACHE_TRANSLATE_NAME);
//        Element e = cache.get(EhcacheConstant.CACHE_TRANSLATE_KEY);
//        Map<String, JSONObject> map = (Map<String, JSONObject>)e.getObjectValue();
//        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
//            System.out.println(entry.getKey()  + "____" + entry.getValue());
//        }
    }
}

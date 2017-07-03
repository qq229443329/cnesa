package com.cnesa;

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
 * Created by shangpeibao on 16/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml", "classpath*:config/ehcache-config.xml"})
public class EhcacheTest {

    @Autowired
    CacheManager cacheManager;

    @Test
    public void test(){
        Long timestamp = System.currentTimeMillis();
        Cache cache = cacheManager.getCache("test");
        Element element = new Element("testk", timestamp);
        cache.put(element);

        Element e1 = cache.get("testk");
        System.out.println(e1.getObjectValue().toString());
        try {
            System.out.println("#####");
            Thread.sleep(6000);
            System.out.println("$$$$");
            test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        test1();

    }

    @Test
    public void test1() {
        Cache cache = cacheManager.getCache(EhcacheConstant.CACHE_TRANSLATE_NAME);
        Element e = cache.get(EhcacheConstant.CACHE_TRANSLATE_KEY);
        Map<String, JSONObject> map = (Map<String, JSONObject>)e.getObjectValue();
        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            System.out.println(e.getObjectKey());
        }
    }
}

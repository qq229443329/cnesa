package com.cnesa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shangpeibao on 17/2/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml", "classpath*:config/redis-config.xml", "classpath*:config/ehcache-config.xml"})
public class TransformerTest {

    @Autowired
    TransformerService transformerService;

//    @Test
//    public void testInsert() {
//        Transformer t = new Transformer();
////        t.setName("1#变压器");
////        t.setType("干式");
////        t.setCapacity("3500");
////        t.setVoltageLevel("不满1千伏");
////        t.setWorkTime("2015-11-01");
////        t.setProjectId("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
////        transformerService.insert(t);
//
//        t.setName("2#变压器");
//        t.setType("晶硅");
//        t.setCapacity("4200");
//        t.setVoltageLevel("1-10千伏");
//        t.setWorkTime("2016-01-01");
//        t.setProjectId("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
//        transformerService.insert(t);
//
//        t.setName("3#变压器");
//        t.setType("晶硅");
//        t.setCapacity("4200");
//        t.setVoltageLevel("1-10千伏");
//        t.setWorkTime("2016-02-06");
//        t.setProjectId("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
//        transformerService.insert(t);
//    }
//
//    @Test
//    public void testDelete(){
//        transformerService.delete(Arrays.asList("bc82b0fe-f257-11e6-bba0-00163e04d0f8", "bcbf5b16-f257-11e6-bba0-00163e04d0f8"));
//    }
//
//    @Test
//    public void testUpdate() {
//        Transformer t = new Transformer();
//        t.setId("58906af0-f257-11e6-bba0-00163e04d0f8");
//        t.setName("3#变压器");
//        t.setType("晶硅");
//        t.setCapacity("4200");
//        t.setVoltageLevel("1-10千伏");
//        t.setWorkTime("2016-02-06");
//        t.setProjectId("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
//        transformerService.update(t);
//    }

    @Test
    public void testSelectAll(){
        List<Transformer> list = transformerService.selectAll("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
        for (Transformer t : list) {
            System.out.println(t.toString());
        }
    }
}

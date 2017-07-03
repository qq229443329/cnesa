package com.cnesa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by shangpeibao on 17/2/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml", "classpath*:config/redis-config.xml", "classpath*:config/ehcache-config.xml"})
public class ElectricityEquipmentTest {

    @Autowired
    ElectricityEquipmentService electricityEquipmentService;

    @Test
    public void testInsert(){
        ElectricityEquipment equipment = new ElectricityEquipment();
        equipment.setName("第一大功率生产设备");
        equipment.setMeterId("064add10-2443-44e0-8589-6fd46884f113");
        equipment.setPower("3000");
        equipment.setRunningTime("08:00-17:00\n" + "20:00-23:00");
        equipment.setNumber(10);
        equipment.setWorkTime("2015-11-01");
        equipment.setProjectId("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
        electricityEquipmentService.insert(equipment);
    }


    @Test
    public void testUpdate(){
        ElectricityEquipment equipment = new ElectricityEquipment();
        equipment.setId("cabb5c40-f259-11e6-bba0-00163e04d0f8");
        equipment.setName("第一大功率生产设备");
        equipment.setMeterId("064add10-2443-44e0-8589-6fd46884f113");
        equipment.setPower("3000");
        equipment.setRunningTime("08:00-17:00\n" + "20:00-23:00");
        equipment.setNumber(10);
        equipment.setWorkTime("2015-11-01");
        equipment.setProjectId("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
        electricityEquipmentService.update(equipment);
    }

    @Test
    public void testSelectAll(){
        List<ElectricityEquipment> list = electricityEquipmentService.selectAll("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
        for (ElectricityEquipment map : list) {
            System.out.println(map.toString());
        }
    }
}

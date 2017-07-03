package com.cnesa;

import com.cnesa.message.redis.RedisOpsService;
import com.cnesa.message.redis.common.RedisInfo;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shangpeibao on 17/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml", "classpath*:config/redis-config.xml", "classpath*:config/ehcache-config.xml"})
public class EventInfoTest {

    @Autowired
    EventInfoService eventInfoService;

    @Autowired
    RedisOpsService redisOpsService;

    @Test
    public void test() {
        EventInfo info = new EventInfo();
        info.setLocation("123");
        info.setSolekey("123");
        info.setProjectId("14f037f6-c2ae-11e6-b138-fe26c35f90b6");
        info.setEvent("123");
        info.setEventTime(new Date());
        int i = eventInfoService.insert(info);
        System.out.println(i);
        System.out.println(info.getId());
    }

    @Test
    public void test1() {
        RedisInfo redisInfo = new RedisInfo();
        redisInfo.setValue("1");
        redisInfo.setTagname("DONGBA#BJ#EM_P002#a_lossvolt");
        redisInfo.setTime(System.currentTimeMillis());
        JSONObject jsonObject = JSONObject.fromObject(redisInfo);
        redisOpsService.redisPublish("alarm_channel", jsonObject.toString());
        int n = 0;
        for (int i=0; i<100; i++) {
            redisOpsService.redisPublish("alarm_channel", jsonObject.toString());
            System.out.println("---------" + n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            n++;
        }



    }


}

package com.cnesa;

import com.cnesa.message.redis.RedisOpsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by shangpeibao on 17/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml", "classpath*:config/redis-config.xml", "classpath*:config/ehcache-config.xml"})
public class RedisTest {

    @Resource
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    RedisOpsService redisOpsService;

    @Test
    public void testSelectRedisAllDatas() {
        RedisConnection connection = null;

        try {
            connection = redisTemplate.getConnectionFactory().getConnection();
            Set<byte[]> set = connection.keys("raw*".getBytes());
            for (byte[] b : set) {
                List<String> list = redisOpsService.hmgetWithConnection(connection, new String(b).replace("raw#", ""));
                if (list.get(1).length() != "2017-02-18 08:25:00".length())
                System.out.println(list.get(0) + "------" + list.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}

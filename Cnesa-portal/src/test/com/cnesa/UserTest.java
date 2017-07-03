package com.cnesa;

import com.cnesa.authority.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by shangpeibao on 17/1/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml"})
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void testSelectAccountInfoByUserId() {
        Map<String, String> map = userService.selectAccountInfoByUserId("a44aa1d2-c111-11e6-aafc-406436e2cb53");
        for (Map.Entry<String, String> m : map.entrySet()) {
            System.out.println(m.getKey());
        }
    }
}

package com.cnesa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shangpeibao on 17/1/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-config.xml", "classpath*:config/redis-config.xml", "classpath*:config/ehcache-config.xml"})
public class CompanyServiceTest {

    @Autowired
    CompanyService companyService;

    @Test
    public void selectUserCompanyByUserId() {
        UserCompanyModel userCompanyModel = companyService.selectUserCompanyByUserId("a44aa1d2-c111-11e6-aafc-406436e2cb53");
        System.out.println(userCompanyModel.toString());

    }
}

package com.cnesa.bos.service.impl;

import com.cnesa.authority.dao.UserDao;
import com.cnesa.authority.entity.User;
import com.cnesa.authority.entity.UserExample;
import com.cnesa.bos.service.LoginService;
//import MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shangpeibao on 16/12/2.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User findByUsernameAndPassword(String username, String password) {
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUsernameEqualTo(username);
            String encodePassword = null;
            try {
//                encodePassword = MD5Util.md5Encode(password);
            } catch (Exception e) {
                logger.error("--UserServiceImpl--findByUsernameAndPassword--密码转变MD5失败：--{}--", e.getMessage(), e);
            }
            criteria.andPasswordEqualTo(encodePassword);
            List<User> users = userDao.selectByExample(userExample);
            if (users != null && users.size() > 0) {
                return users.get(0);
            }
        }

        return null;
    }
}

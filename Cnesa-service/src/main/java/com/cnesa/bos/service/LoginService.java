package com.cnesa.bos.service;

import com.cnesa.authority.entity.User;

/**
 * Created by shangpeibao on 16/12/2.
 *
 * 用户相关
 */
public interface LoginService {

    public User findByUsernameAndPassword(String username, String password);
}

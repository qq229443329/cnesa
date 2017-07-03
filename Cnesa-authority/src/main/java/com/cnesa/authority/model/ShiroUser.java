package com.cnesa.authority.model;

import java.util.List;

/**
 * Created by shangpeibao on 16/12/6.
 *
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 *
 */
public class ShiroUser implements java.io.Serializable {

    public String id;
    public String loginName;
    public String name;
    public String token;
    public List<String> roleList;

    public ShiroUser(String id, String loginName, String name, String token, List<String> roleList) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.token = token;
        this.roleList = roleList;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return loginName;
    }
}

package com.cnesa.authority.model;

import java.util.List;

/**
 *  token解析对象
 * Created by shangpeibao on 16/12/21.
 */
public class CurrentUser implements java.io.Serializable {

    private static String id;
    private static String username;
    private static String token;
    private static List<String> resources;

    private CurrentUser() {
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        CurrentUser.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CurrentUser.username = username;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        CurrentUser.token = token;
    }

    public static List<String> getResources() {
        return resources;
    }

    public static void setResources(List<String> resources) {
        CurrentUser.resources = resources;
    }

    /**
     * 删除当前用户
     */
    public static void empty() {
        CurrentUser.id = null;
        CurrentUser.username = null;
        CurrentUser.token = null;
        CurrentUser.resources.clear();
    }
}

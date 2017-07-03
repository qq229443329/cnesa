package com.cnesa.authority.common;

/**
 * Created by shangpeibao on 16/12/20.
 */
public class Token {

    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Token.token = token;
    }
}

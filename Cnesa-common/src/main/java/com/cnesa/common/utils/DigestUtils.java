package com.cnesa.common.utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by shangpeibao on 16/12/7.
 *
 * 加密相关工具类直接使用Spring util封装，减少jar依赖
 */
public class DigestUtils extends org.springframework.util.DigestUtils {

    /**
     * Calculates the MD5 digest and returns the value as a 32 character hex string.
     *
     * @param data Data to digest
     * @return MD5 digest as a hex string
     */
    public static String md5Hex(final String data) throws UnsupportedEncodingException{
        byte[] b = data.getBytes("utf-8");
        return DigestUtils.md5DigestAsHex(b);
    }

    /**
     * Return a hexadecimal string representation of the MD5 digest of the given bytes.
     * @param bytes the bytes to calculate the digest over
     * @return a hexadecimal digest string
     */
    public static String md5Hex(final byte[] bytes) {
        return DigestUtils.md5DigestAsHex(bytes);
    }

    public static void main(String[] args) {
        DigestUtils.md5DigestAsHex("12".getBytes());
    }
}

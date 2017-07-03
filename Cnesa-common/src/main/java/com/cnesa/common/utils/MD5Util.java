package com.cnesa.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shangpeibao on 16/12/2.
 *
 * MD5 加密
 */
public class MD5Util {

    private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);

    public static String md5Encode(String encodeStr) throws Exception{
        MessageDigest md = null;
        String md5Str = "";
        StringBuilder builder = new StringBuilder();
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.error("--MD5Util--md5Encode--获取MessageDigest失败--{}--", e.getMessage(), e);
        }

        byte[] md5Bytes = md.digest(encodeStr.getBytes("utf-8"));
        for (int i=0; i<md5Bytes.length; i++) {
            int val = (int)md5Bytes[i] & 0xff;
            if (val < 16) {
                builder.append("0");
            }
            builder.append(Integer.toHexString(val));
        }
        md5Str = builder.toString();
        return md5Str;
    }

}

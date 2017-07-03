package com.cnesa.common.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by shangpeibao on 17/1/11.
 *
 * 通过反射将Map值 赋值给 实体类
 */
public class MapToObjectUtil {
    private static final Logger logger = LoggerFactory.getLogger(MapToObjectUtil.class);
    private static DateFormat ymd = new SimpleDateFormat("yyyy-MM-dd"),ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Object mapToObject(Map<String, String> map, Class clazz) {
        Object obj = null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method method;
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Class fieldClass = f.getType();
            String fieldName = f.getName();
            String stringLetter = fieldName.substring(0, 1).toUpperCase();
            String setMethod = "set" + stringLetter + fieldName.substring(1);
            if (!map.containsKey(fieldName)) {
                continue;
            }
            String mapV = map.get(fieldName);
            try {
                if (hasMethod(setMethod, clazz)) {
                    method = clazz.getMethod(setMethod, fieldClass);
                    if (fieldClass == String.class) {
                        method.invoke(obj, mapV);
                    } else if (fieldClass == Date.class) {
                        if (mapV.length() == 19) {
                            method.invoke(obj, ymdhms.parse(mapV));
                        } else if (mapV.length() == 10){
                            method.invoke(obj, ymd.parse(mapV));
                        }
                    } else if (fieldClass == Integer.class) {
                        method.invoke(obj, Integer.parseInt(mapV));
                    }
                }
            } catch (NoSuchMethodException e) {
                logger.error("--MapToObjectUtil--mapToObject--获取实体方法失败--{}--", e.getMessage());
            } catch (InvocationTargetException e) {
                logger.error("--MapToObjectUtil--mapToObject--给实体赋值失败--{}--", e.getMessage());
            } catch (IllegalAccessException e) {
                logger.error("--MapToObjectUtil--mapToObject--给实体赋值失败--{}--", e.getMessage());
            } catch (ParseException e) {
                logger.error("--MapToObjectUtil--mapToObject--日期类型转换失败失败--{}--", e.getMessage());
            }
        }
        return obj;
    }

    private static boolean hasMethod(String method, Class clazz) {
        boolean result = false;
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            if (m.getName().equals(method)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

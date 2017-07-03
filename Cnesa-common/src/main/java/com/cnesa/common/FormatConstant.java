package com.cnesa.common;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by shangpeibao on 17/4/25.
 *
 * 时间格式常量
 */
public class FormatConstant {

    public static final DateFormat df_ym = new SimpleDateFormat("yyyy-MM");
    public static final DateFormat df_ymd = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat df_ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateFormat df_ymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final DateFormat df_hm = new SimpleDateFormat("HH:mm");
    public static final DateFormat df_mdhm = new SimpleDateFormat("MM-dd HH:mm");
    public static final DateFormat df_d = new SimpleDateFormat("dd");

    public static final DecimalFormat value_df = new DecimalFormat("#.##");
}

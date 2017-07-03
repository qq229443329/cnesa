package com.cnesa.authority.common;

/**
 * 资源菜单相关常量
 *
 * Created by shangpeibao on 16/12/7.
 */
public class AuthorityConstant {

    /**
     * 权限资源
     */
    public static final int MENU_TYPE_RESOURCE = 0;

    /**
     * 前端显示菜单
     */
    public static final int MENU_TYPE_MENU = 2;

    /**
     * 按钮资源
     */
    public static final int MENU_TYPE_BTN = 1;

    /**
     * 菜单隐藏
     */
    public static final int MENU_STATUS_HIDDEN = 0;
    /**
     * 菜单显示
     */
    public static final int MENU_STATUS_SHOW = 1;

    /**
     * 菜单功能——配置功能
     */
    public static final int MENU_FUNCTION_CONFIG = 0;
    /**
     * 菜单功能——权限功能
     */
    public static final int MENU_FUNCTION_AUTHORITY = 1;
    /**
     * 菜单功能——菜单功能
     */
    public static final int MENU_FUNCTION_MENU = 2;

    /**
     * 角色不可用
     */
    public static final int ROLE_STATUS_HIDDEN = 0;

    /**
     * 角色可用
     */
    public static final int ROLE_STATUS_SHOW = 1;

    /**
     * 普通用户
     */
    public static final int USER_TYPE_GENERAL = 0;

    /**
     * 管理员
     */
    public static final int USER_TYPE_MANAGER = 1;

    /**
     * 超级管理员
     */
    public static final int USER_TYPE_ADMIN = 2;

    /**
     * 不可用
     */
    public static final int USER_STATUS_UNAVAILABLE = 0;

    /**
     * 可用，未登录
     */
    public static final int USER_STATUS_AVAILABLE = 1;

    /**
     * 已登录
     */
    public static final int USER_STATUS_LOGIN = 2;

}

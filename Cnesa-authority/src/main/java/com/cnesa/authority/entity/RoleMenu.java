package com.cnesa.authority.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 角色资源表
 *
 */
@TableName("AUTH_ROLE_MENU")
public class RoleMenu implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 2064963051404755212L;

    /** 主键 */
    @TableId(type = IdType.UUID)
    private String id;

    /** 角色ID */
    @TableField(value = "role_id")
    private String roleId;

    /** 资源菜单ID */
    @TableField(value = "menu_id")
    private String menuId;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

}

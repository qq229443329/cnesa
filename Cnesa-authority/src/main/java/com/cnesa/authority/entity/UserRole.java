package com.cnesa.authority.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 用户角色表
 *
 */
@TableName("AUTH_USER_ROLE")
public class UserRole implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -6143278545628718630L;

    /** 主键 */
    @TableId(type = IdType.UUID)
    private String id;

    /** 角色ID */
    @TableField(value = "role_id")
    private String roleId;

    /** 用户ID */
    @TableField(value = "user_id")
    private String userId;

    public UserRole() {
    }

    public UserRole(String id, String roleId, String userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }

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

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

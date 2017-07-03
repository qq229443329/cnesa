package com.cnesa.authority.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 角色表
 *
 */
@TableName("AUTH_ROLE")
public class Role implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -964247521217308600L;

    /** 主键 */
    @TableId(type = IdType.UUID)
    private String id;

    /** 角色名称 */
    @TableField(value = "role_name")
    private String roleName;

    /** 创建时间 */
    @TableField(value = "create_time")
    private Date createTime;

    /** 修改时间 */
    @TableField(value = "update_time")
    private Date updateTime;

    /** 描述 */
    private String description;

    /** 排序序号 */
    private Integer seq;

    /** 角色状态, 0:未激活,1:已激活 */
    private Integer status;

    public Role() {
    }

    public Role(String id, String roleName, Date createTime, Date updateTime, String description, Integer seq, Integer status) {
        this.id = id;
        this.roleName = roleName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.description = description;
        this.seq = seq;
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", seq=" + seq +
                ", status=" + status +
                '}';
    }
}

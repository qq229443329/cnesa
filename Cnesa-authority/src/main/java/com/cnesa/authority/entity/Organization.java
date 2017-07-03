package com.cnesa.authority.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 组织表
 *
 */
@TableName("AUTH_ORGANIZATION")
public class Organization implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -3879913314636655670L;

    /** 主键 */
    @TableId(type = IdType.UUID)
    private String id;

    /** 组织名称 */
    private String name;

    /** 组织编码 */
    private String code;

    /** 组织地点 */
    private String address;

    /** 组织描述 */
    private String description;

    /** 组织图标 */
    private String icon;

    private Integer seq;

    /** 所属父类 */
    @TableField(value = "parent_id")
    private String parentId;

    /** 创建时间 */
    @TableField(value = "create_time")
    private Date createTime;

    public Organization() {
    }

    public Organization(String id, String name, String code, String address, String description, String icon, Integer seq, String parentId, Date createTime) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
        this.description = description;
        this.icon = icon;
        this.seq = seq;
        this.parentId = parentId;
        this.createTime = createTime;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", seq='" + seq + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", parentId='" + parentId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

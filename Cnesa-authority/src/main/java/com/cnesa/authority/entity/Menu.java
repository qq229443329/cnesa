package com.cnesa.authority.entity;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 资源菜单表
 *
 */
@TableName("MG_MENU")
public class Menu implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -324693195203962733L;

    /** 主键 */
    @TableId(type = IdType.UUID)
    private String id;

    /** 菜单名称 */
    private String name;

    /** 菜单描述 */
    private String description;

    /** 是否显示，默认1显示 */
    private Integer status;

    /** 显示序号 */
    private Integer seq;

    /** 图标 */
    @JsonProperty(value = "iconCls")
    private String icon;

    /** 节点展开状态 open/close */
    private String state;

    /** 请求URL */
    private String url;

    /** 资源类型，0:菜单，1:按钮 */
    @TableField(value = "resource_type")
    private Integer resourceType;

    /** 功能类型；0配置用途，1权限用途，2菜单用途 */
    @TableField(value = "function_type")
    private Integer functionType;

    /** 所属父类 */
    @TableField(value = "parent_id")
    private String parentId;

    /** 创建时间 */
    @TableField(value = "create_time")
    private Date createTime;

    public Menu() {
    }

    public Menu(String id, String name, String description, Integer status, Integer seq, String icon, String state, String url, Integer resourceType, Integer functionType, String parentId, Date createTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.seq = seq;
        this.icon = icon;
        this.state = state;
        this.url = url;
        this.resourceType = resourceType;
        this.functionType = functionType;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getResourceType() {
        return this.resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Integer functionType) {
        this.functionType = functionType;
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
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", seq=" + seq +
                ", icon='" + icon + '\'' +
                ", state='" + state + '\'' +
                ", url='" + url + '\'' +
                ", resourceType=" + resourceType +
                ", functionType=" + functionType +
                ", parentId='" + parentId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

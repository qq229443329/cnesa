package com.cnesa.authority.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 用户表
 *
 */
@TableName("AUTH_USER")
public class User implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -1566772047750828449L;

    /** 主键 */
    @TableId(type = IdType.UUID)
    private String id;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 真实姓名 */
    @TableField(value = "real_name")
    private String realName;

    /** 邮箱 */
    private String email;

    /** 移动电话 */
    private String mobile;

    /** 头像 */
    private String icon;

    /** 传真 */
    @TableField(value = "fax_number")
    private String faxNumber;

    /** 用户登录状态, 100:表示超级管理员;0:未激活,1:已激活,2:已登录 */
    private Integer status;

    /** 用户类型 0:普通用户, 1:管理员, 2:超级管理员 */
    @TableField(value = "user_type")
    private Integer userType;

    /** 性别 */
    private Integer sex;

    /** 出生日期 */
    private Date birthday;

    /** 所属组织 */
    @TableField(value = "org_id")
    private String orgId;

    /** 所属企业 */
    @TableField(value = "com_id")
    private String comId;

    /** 用户登录token */
    private String token;

    /** 所在区域 */
    private String region;

    /** 详细地址 */
    private String location;

    /**  职位 */
    private String position;

    /** 预留字段1 */
    @TableField(value = "prestore_a")
    private String prestoreA;

    /** 预留字段2 */
    @TableField(value = "prestore_b")
    private String prestoreB;

    /** 预留字段3 */
    @TableField(value = "prestore_c")
    private String prestoreC;

    /** 创建时间 */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private List<Role> rolesList;
    @TableField(exist = false)
    private String organizationName;
    @TableField(exist = false)
    private List<String> roleIds;
    @TableField(exist = false)
    private String companyName;

    /**
     * 用于检索
     */
    @TableField(exist = false)
    private Date createdateStart;
    @TableField(exist = false)
    private Date createdateEnd;

    public User() {
    }

    public User(String id, String username, String password, String realName, String email, String mobile, String icon, String faxNumber, Integer status, Integer userType, Integer sex, Date birthday, String orgId, String comId, String token, String region, String location, String position, String prestoreA, String prestoreB, String prestoreC, Date createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.email = email;
        this.mobile = mobile;
        this.icon = icon;
        this.faxNumber = faxNumber;
        this.status = status;
        this.userType = userType;
        this.sex = sex;
        this.birthday = birthday;
        this.orgId = orgId;
        this.comId = comId;
        this.token = token;
        this.region = region;
        this.location = location;
        this.position = position;
        this.prestoreA = prestoreA;
        this.prestoreB = prestoreB;
        this.prestoreC = prestoreC;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPrestoreA() {
        return prestoreA;
    }

    public void setPrestoreA(String prestoreA) {
        this.prestoreA = prestoreA;
    }

    public String getPrestoreB() {
        return prestoreB;
    }

    public void setPrestoreB(String prestoreB) {
        this.prestoreB = prestoreB;
    }

    public String getPrestoreC() {
        return prestoreC;
    }

    public void setPrestoreC(String prestoreC) {
        this.prestoreC = prestoreC;
    }

    public List<Role> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Role> rolesList) {
        this.rolesList = rolesList;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getCreatedateStart() {
        return createdateStart;
    }

    public void setCreatedateStart(Date createdateStart) {
        this.createdateStart = createdateStart;
    }

    public Date getCreatedateEnd() {
        return createdateEnd;
    }

    public void setCreatedateEnd(Date createdateEnd) {
        this.createdateEnd = createdateEnd;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }


    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", icon='" + icon + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", status=" + status +
                ", userType=" + userType +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", orgId='" + orgId + '\'' +
                ", comId='" + comId + '\'' +
                ", token='" + token + '\'' +
                ", region='" + region + '\'' +
                ", location='" + location + '\'' +
                ", position='" + position + '\'' +
                ", prestoreA='" + prestoreA + '\'' +
                ", prestoreB='" + prestoreB + '\'' +
                ", prestoreC='" + prestoreC + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

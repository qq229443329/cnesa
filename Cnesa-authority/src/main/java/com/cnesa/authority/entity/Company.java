package com.cnesa.authority.entity;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 企业表
 *
 */
@TableName("MG_COMPANY")
public class Company implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键 */
	@TableId(type = IdType.UUID)
	private String id;

	/** 企业编码 */
	private String code;

	/** 企业名称 */
	private String name;

	/** 企业描述 */
	private String description;

	/** 所属行业 */
	private String industry;

	/** 企业规模 */
	@TableField(value = "people_size")
	private String peopleSize;

	/** 工作时间 */
	@TableField(value = "working_time")
	private String workingTime;

	/** 企业法人 */
	@TableField(value = "legal_people")
	private String legalPeople;

	/** 法人电话 */
	@TableField(value = "legal_mobile")
	private String legalMobile;

	/** 企业联系人 */
	@TableField(value = "contact_people")
	private String contactPeople;

	/** 联系人电话 */
	@TableField(value = "contact_mobile")
	private String contactMobile;

	/** 企业许可编号 */
	@TableField(value = "busniess_num")
	private String busniessNum;

	/** 企业营业执照 */
	@TableField(value = "busniess_license")
	private String busniessLicense;

	/** 企业logo */
	@TableField(value = "icon_logo")
	private String iconLogo;

	/** 所在区域 */
	private String region;

	/** 详细地址 */
	private String location;

	/** 创建时间 */
	@TableField(value = "create_time")
	private Date createTime;

	public Company() {
	}

	public Company(String id, String code, String name, String description, String industry, String peopleSize, String workingTime, String legalPeople, String legalMobile, String contactPeople, String contactMobile, String busniessNum, String busniessLicense, String iconLogo, String region, String location, Date createTime) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.industry = industry;
		this.peopleSize = peopleSize;
		this.workingTime = workingTime;
		this.legalPeople = legalPeople;
		this.legalMobile = legalMobile;
		this.contactPeople = contactPeople;
		this.contactMobile = contactMobile;
		this.busniessNum = busniessNum;
		this.busniessLicense = busniessLicense;
		this.iconLogo = iconLogo;
		this.region = region;
		this.location = location;
		this.createTime = createTime;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPeopleSize() {
		return this.peopleSize;
	}

	public void setPeopleSize(String peopleSize) {
		this.peopleSize = peopleSize;
	}

	public String getWorkingTime() {
		return this.workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public String getLegalPeople() {
		return this.legalPeople;
	}

	public void setLegalPeople(String legalPeople) {
		this.legalPeople = legalPeople;
	}

	public String getLegalMobile() {
		return this.legalMobile;
	}

	public void setLegalMobile(String legalMobile) {
		this.legalMobile = legalMobile;
	}

	public String getContactPeople() {
		return this.contactPeople;
	}

	public void setContactPeople(String contactPeople) {
		this.contactPeople = contactPeople;
	}

	public String getContactMobile() {
		return this.contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getBusniessNum() {
		return this.busniessNum;
	}

	public void setBusniessNum(String busniessNum) {
		this.busniessNum = busniessNum;
	}

	public String getBusniessLicense() {
		return this.busniessLicense;
	}

	public void setBusniessLicense(String busniessLicense) {
		this.busniessLicense = busniessLicense;
	}

	public String getIconLogo() {
		return this.iconLogo;
	}

	public void setIconLogo(String iconLogo) {
		this.iconLogo = iconLogo;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	@Override
	public String toString() {
		return "Company{" +
				"id='" + id + '\'' +
				", code='" + code + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", industry='" + industry + '\'' +
				", peopleSize='" + peopleSize + '\'' +
				", workingTime='" + workingTime + '\'' +
				", legalPeople='" + legalPeople + '\'' +
				", legalMobile='" + legalMobile + '\'' +
				", contactPeople='" + contactPeople + '\'' +
				", contactMobile='" + contactMobile + '\'' +
				", busniessNum='" + busniessNum + '\'' +
				", busniessLicense='" + busniessLicense + '\'' +
				", iconLogo='" + iconLogo + '\'' +
				", region='" + region + '\'' +
				", location='" + location + '\'' +
				", createTime=" + createTime +
				'}';
	}
}

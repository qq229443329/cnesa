package com.cnesa.authority.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeIsNull() {
            addCriterion("people_size is null");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeIsNotNull() {
            addCriterion("people_size is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeEqualTo(String value) {
            addCriterion("people_size =", value, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeNotEqualTo(String value) {
            addCriterion("people_size <>", value, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeGreaterThan(String value) {
            addCriterion("people_size >", value, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeGreaterThanOrEqualTo(String value) {
            addCriterion("people_size >=", value, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeLessThan(String value) {
            addCriterion("people_size <", value, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeLessThanOrEqualTo(String value) {
            addCriterion("people_size <=", value, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeLike(String value) {
            addCriterion("people_size like", value, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeNotLike(String value) {
            addCriterion("people_size not like", value, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeIn(List<String> values) {
            addCriterion("people_size in", values, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeNotIn(List<String> values) {
            addCriterion("people_size not in", values, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeBetween(String value1, String value2) {
            addCriterion("people_size between", value1, value2, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andPeopleSizeNotBetween(String value1, String value2) {
            addCriterion("people_size not between", value1, value2, "peopleSize");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeIsNull() {
            addCriterion("working_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeIsNotNull() {
            addCriterion("working_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeEqualTo(String value) {
            addCriterion("working_time =", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeNotEqualTo(String value) {
            addCriterion("working_time <>", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeGreaterThan(String value) {
            addCriterion("working_time >", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("working_time >=", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeLessThan(String value) {
            addCriterion("working_time <", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeLessThanOrEqualTo(String value) {
            addCriterion("working_time <=", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeLike(String value) {
            addCriterion("working_time like", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeNotLike(String value) {
            addCriterion("working_time not like", value, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeIn(List<String> values) {
            addCriterion("working_time in", values, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeNotIn(List<String> values) {
            addCriterion("working_time not in", values, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeBetween(String value1, String value2) {
            addCriterion("working_time between", value1, value2, "workingTime");
            return (Criteria) this;
        }

        public Criteria andWorkingTimeNotBetween(String value1, String value2) {
            addCriterion("working_time not between", value1, value2, "workingTime");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleIsNull() {
            addCriterion("legal_people is null");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleIsNotNull() {
            addCriterion("legal_people is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleEqualTo(String value) {
            addCriterion("legal_people =", value, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleNotEqualTo(String value) {
            addCriterion("legal_people <>", value, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleGreaterThan(String value) {
            addCriterion("legal_people >", value, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("legal_people >=", value, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleLessThan(String value) {
            addCriterion("legal_people <", value, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleLessThanOrEqualTo(String value) {
            addCriterion("legal_people <=", value, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleLike(String value) {
            addCriterion("legal_people like", value, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleNotLike(String value) {
            addCriterion("legal_people not like", value, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleIn(List<String> values) {
            addCriterion("legal_people in", values, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleNotIn(List<String> values) {
            addCriterion("legal_people not in", values, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleBetween(String value1, String value2) {
            addCriterion("legal_people between", value1, value2, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalPeopleNotBetween(String value1, String value2) {
            addCriterion("legal_people not between", value1, value2, "legalPeople");
            return (Criteria) this;
        }

        public Criteria andLegalMobileIsNull() {
            addCriterion("legal_mobile is null");
            return (Criteria) this;
        }

        public Criteria andLegalMobileIsNotNull() {
            addCriterion("legal_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andLegalMobileEqualTo(String value) {
            addCriterion("legal_mobile =", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileNotEqualTo(String value) {
            addCriterion("legal_mobile <>", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileGreaterThan(String value) {
            addCriterion("legal_mobile >", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileGreaterThanOrEqualTo(String value) {
            addCriterion("legal_mobile >=", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileLessThan(String value) {
            addCriterion("legal_mobile <", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileLessThanOrEqualTo(String value) {
            addCriterion("legal_mobile <=", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileLike(String value) {
            addCriterion("legal_mobile like", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileNotLike(String value) {
            addCriterion("legal_mobile not like", value, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileIn(List<String> values) {
            addCriterion("legal_mobile in", values, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileNotIn(List<String> values) {
            addCriterion("legal_mobile not in", values, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileBetween(String value1, String value2) {
            addCriterion("legal_mobile between", value1, value2, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andLegalMobileNotBetween(String value1, String value2) {
            addCriterion("legal_mobile not between", value1, value2, "legalMobile");
            return (Criteria) this;
        }

        public Criteria andContactPeopleIsNull() {
            addCriterion("contact_people is null");
            return (Criteria) this;
        }

        public Criteria andContactPeopleIsNotNull() {
            addCriterion("contact_people is not null");
            return (Criteria) this;
        }

        public Criteria andContactPeopleEqualTo(String value) {
            addCriterion("contact_people =", value, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleNotEqualTo(String value) {
            addCriterion("contact_people <>", value, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleGreaterThan(String value) {
            addCriterion("contact_people >", value, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("contact_people >=", value, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleLessThan(String value) {
            addCriterion("contact_people <", value, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleLessThanOrEqualTo(String value) {
            addCriterion("contact_people <=", value, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleLike(String value) {
            addCriterion("contact_people like", value, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleNotLike(String value) {
            addCriterion("contact_people not like", value, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleIn(List<String> values) {
            addCriterion("contact_people in", values, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleNotIn(List<String> values) {
            addCriterion("contact_people not in", values, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleBetween(String value1, String value2) {
            addCriterion("contact_people between", value1, value2, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactPeopleNotBetween(String value1, String value2) {
            addCriterion("contact_people not between", value1, value2, "contactPeople");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNull() {
            addCriterion("contact_mobile is null");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNotNull() {
            addCriterion("contact_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andContactMobileEqualTo(String value) {
            addCriterion("contact_mobile =", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotEqualTo(String value) {
            addCriterion("contact_mobile <>", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThan(String value) {
            addCriterion("contact_mobile >", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThanOrEqualTo(String value) {
            addCriterion("contact_mobile >=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThan(String value) {
            addCriterion("contact_mobile <", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThanOrEqualTo(String value) {
            addCriterion("contact_mobile <=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLike(String value) {
            addCriterion("contact_mobile like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotLike(String value) {
            addCriterion("contact_mobile not like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileIn(List<String> values) {
            addCriterion("contact_mobile in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotIn(List<String> values) {
            addCriterion("contact_mobile not in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileBetween(String value1, String value2) {
            addCriterion("contact_mobile between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotBetween(String value1, String value2) {
            addCriterion("contact_mobile not between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andBusniessNumIsNull() {
            addCriterion("busniess_num is null");
            return (Criteria) this;
        }

        public Criteria andBusniessNumIsNotNull() {
            addCriterion("busniess_num is not null");
            return (Criteria) this;
        }

        public Criteria andBusniessNumEqualTo(String value) {
            addCriterion("busniess_num =", value, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumNotEqualTo(String value) {
            addCriterion("busniess_num <>", value, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumGreaterThan(String value) {
            addCriterion("busniess_num >", value, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumGreaterThanOrEqualTo(String value) {
            addCriterion("busniess_num >=", value, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumLessThan(String value) {
            addCriterion("busniess_num <", value, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumLessThanOrEqualTo(String value) {
            addCriterion("busniess_num <=", value, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumLike(String value) {
            addCriterion("busniess_num like", value, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumNotLike(String value) {
            addCriterion("busniess_num not like", value, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumIn(List<String> values) {
            addCriterion("busniess_num in", values, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumNotIn(List<String> values) {
            addCriterion("busniess_num not in", values, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumBetween(String value1, String value2) {
            addCriterion("busniess_num between", value1, value2, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessNumNotBetween(String value1, String value2) {
            addCriterion("busniess_num not between", value1, value2, "busniessNum");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseIsNull() {
            addCriterion("busniess_license is null");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseIsNotNull() {
            addCriterion("busniess_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseEqualTo(String value) {
            addCriterion("busniess_license =", value, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseNotEqualTo(String value) {
            addCriterion("busniess_license <>", value, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseGreaterThan(String value) {
            addCriterion("busniess_license >", value, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("busniess_license >=", value, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseLessThan(String value) {
            addCriterion("busniess_license <", value, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseLessThanOrEqualTo(String value) {
            addCriterion("busniess_license <=", value, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseLike(String value) {
            addCriterion("busniess_license like", value, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseNotLike(String value) {
            addCriterion("busniess_license not like", value, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseIn(List<String> values) {
            addCriterion("busniess_license in", values, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseNotIn(List<String> values) {
            addCriterion("busniess_license not in", values, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseBetween(String value1, String value2) {
            addCriterion("busniess_license between", value1, value2, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andBusniessLicenseNotBetween(String value1, String value2) {
            addCriterion("busniess_license not between", value1, value2, "busniessLicense");
            return (Criteria) this;
        }

        public Criteria andIconLogoIsNull() {
            addCriterion("icon_logo is null");
            return (Criteria) this;
        }

        public Criteria andIconLogoIsNotNull() {
            addCriterion("icon_logo is not null");
            return (Criteria) this;
        }

        public Criteria andIconLogoEqualTo(String value) {
            addCriterion("icon_logo =", value, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoNotEqualTo(String value) {
            addCriterion("icon_logo <>", value, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoGreaterThan(String value) {
            addCriterion("icon_logo >", value, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoGreaterThanOrEqualTo(String value) {
            addCriterion("icon_logo >=", value, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoLessThan(String value) {
            addCriterion("icon_logo <", value, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoLessThanOrEqualTo(String value) {
            addCriterion("icon_logo <=", value, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoLike(String value) {
            addCriterion("icon_logo like", value, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoNotLike(String value) {
            addCriterion("icon_logo not like", value, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoIn(List<String> values) {
            addCriterion("icon_logo in", values, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoNotIn(List<String> values) {
            addCriterion("icon_logo not in", values, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoBetween(String value1, String value2) {
            addCriterion("icon_logo between", value1, value2, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andIconLogoNotBetween(String value1, String value2) {
            addCriterion("icon_logo not between", value1, value2, "iconLogo");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
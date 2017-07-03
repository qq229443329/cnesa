package com.cnesa.authority.dao;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cnesa.authority.entity.Company;
import com.cnesa.authority.entity.CompanyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by shangpeibao on 16/12/12.
 */
public interface CompanyDao extends AutoMapper<Company> {

    long countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> selectByUserId(@Param("userId") String userId);

    List<Company> selectCompanyList(Page<Company> page, @Param("sort") String sort, @Param("order") String order);
}

package com.cnesa.authority.service;

import com.cnesa.authority.entity.Company;
import com.cnesa.common.model.EasyuiPage;
import com.cnesa.common.model.EasyuiTree;

import java.util.List;

/**
 * 企业接口
 * Created by shangpeibao on 16/12/21.
 */
public interface CompanyService {

    /**
     * 查询用户所属企业
     * @param userId 用户ID
     * @return
     */
    public List<Company> selectByUserId(String userId);


    /**
     * 更新企业信息
     * @param company
     * @return
     */
    boolean updateByCompany(Company company);

    /**
     * 获取企业列表
     * @param easyuiPage
     */
    void selectDataGrid(EasyuiPage easyuiPage);

    /**
     * 添加企业
     * @param company 企业实体
     */
    void insert(Company company);

    /**
     * 删除企业
     * @param id 企业ID
     */
    void delete(String id);

    /**
     * 通过ID查询企业
     * @param id 企业ID
     * @return
     */
    Company selectById(String id);

    /**
     * 查询所有企业
     * @return
     */
    List<EasyuiTree> selectAllForTree();
}

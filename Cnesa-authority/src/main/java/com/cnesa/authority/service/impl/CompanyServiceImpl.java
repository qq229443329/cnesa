package com.cnesa.authority.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.cnesa.authority.dao.CompanyDao;
import com.cnesa.authority.entity.Company;
import com.cnesa.authority.service.CompanyService;
import com.cnesa.common.model.EasyuiPage;
import com.cnesa.common.model.EasyuiTree;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shangpeibao on 16/12/21.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyDao companyDao;

    public List<Company> selectByUserId(String userId) {
        List<Company> companies = null;
        if (StringUtils.hasLength(userId)) {
            companies = companyDao.selectByUserId(userId);
        }
        return companies;
    }

    public boolean updateByCompany(Company company) {
        if (company != null && StringUtils.hasLength(company.getId())) {
            int i = companyDao.updateByPrimaryKeySelective(company);
            return i>0;
        }
        return false;
    }

    public void selectDataGrid(EasyuiPage easyuiPage) {
        Page<Company> page = new Page<Company>(easyuiPage.getNowpage(), easyuiPage.getSize());
        List<Company> list = companyDao.selectCompanyList(page, easyuiPage.getSort(), easyuiPage.getOrder());
        easyuiPage.setRows(list);
        easyuiPage.setTotal(page.getTotal());
    }

    public void insert(Company company) {
        if (company != null){
            company.setCreateTime(new Date(System.currentTimeMillis()));
            companyDao.insert(company);
        }
    }

    public void delete(String id) {
        if (StringUtils.hasLength(id)) {
            companyDao.deleteByPrimaryKey(id);
        }
    }

    public Company selectById(String id) {
        if (StringUtils.hasLength(id)) {
            return companyDao.selectByPrimaryKey(id);
        }
        return null;
    }

    public List<EasyuiTree> selectAllForTree() {
        List<EasyuiTree> easyuiTrees = new ArrayList<EasyuiTree>();
        List<Company> companies =  companyDao.selectByExample(null);
        EasyuiTree easyuiTree;
        if (companies != null && companies.size() > 0) {
            for (Company c : companies) {
                easyuiTree = new EasyuiTree();
                easyuiTree.setId(c.getId());
                easyuiTree.setText(c.getName());
                easyuiTrees.add(easyuiTree);
            }
        }
        return easyuiTrees;
    }
}

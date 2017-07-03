package com.cnesa.authority.controller;

import com.cnesa.authority.entity.Company;
import com.cnesa.authority.service.CompanyService;
import com.cnesa.common.model.BackMessage;
import com.cnesa.common.model.EasyuiPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shangpeibao on 17/3/9.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/company")
@RestController
public class CompanyController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    CompanyService companyService;

    /**
     * 获取企业列表
     * @param page 页码
     * @param rows 行数
     * @param sort 排序列名
     * @param order 排序方式
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    public BackMessage companyDataGrid(Integer page, Integer rows, String sort, String order) {
        BackMessage message = new BackMessage();
        EasyuiPage easyuiPage = new EasyuiPage(page, rows, sort, order);
        Map<String, Object> condition = new HashMap<String, Object>();
        try {
            easyuiPage.setCondition(condition);
            companyService.selectDataGrid(easyuiPage);
            message.setData(easyuiPage);
            message.setSuccess(true);
        } catch (Exception e) {
            message.setError(e.getMessage());
            logger.error("--CompanyController--companyDataGrid--获取角色列表失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 添加企业
     * @param company 企业实体
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BackMessage addCompany(Company company) {
        BackMessage message = new BackMessage();
        try {
            companyService.insert(company);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setError(e.getMessage());
            message.setMsg("操作失败!");
            logger.error("--CompanyController--addCompany--添加失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 删除企业
     * @param id 企业ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public BackMessage deleteCompany(String id) {
        BackMessage message = new BackMessage();
        try {
            companyService.delete(id);
            message.setSuccess(true);
            message.setMsg("删除成功!");
        } catch (Exception e) {
            message.setMsg("删除失败!");
            message.setError(e.getMessage());
            logger.error("--CompanyController--deleteCompany--删除失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 更新企业信息
     * @param company 企业实体
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public BackMessage editCompany(Company company) {
        BackMessage message = new BackMessage();
        try {
            message.setSuccess(companyService.updateByCompany(company));
            message.setMsg("编辑成功!");
        } catch (Exception e) {
            message.setMsg("编辑成功!");
            message.setError(e.getMessage());
            logger.error("--CompanyController--editCompany--编辑失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 获取所有企业列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public BackMessage companyList() {
        BackMessage message = new BackMessage();
        try {
            message.setData(companyService.selectAllForTree());
            message.setSuccess(true);
        } catch (Exception e) {
            message.setError(e.getMessage());
            logger.error("--CompanyController--companyList--查询企业列表失败--{}--", e.getMessage(), e);
        }
        return message;
    }
}

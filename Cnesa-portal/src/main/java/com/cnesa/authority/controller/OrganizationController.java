package com.cnesa.authority.controller;

import base.BaseController;
import com.cnesa.authority.entity.Organization;
import com.cnesa.authority.service.OrganizationService;
import com.cnesa.common.model.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  组织操作
 *
 * Created by shangpeibao on 16/12/9.
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

    @Autowired
    private OrganizationService organizationService;

    /**
     * 获取组织树
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    @ResponseBody
    public Object tree() {
        try {
            return organizationService.selectTree();
        } catch (Exception e) {
            logger.error("--OrganizationController--tree--获取部门树失败--{}--", e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取部门列表
     * @return
     */
    @RequestMapping(value = "/treeGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object treeGrid() {
        return organizationService.selectTreeGrid();
    }

    /**
     * 添加部门
     * @param organization
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage addOrganization(Organization organization) {
        BackMessage message = new BackMessage();
        try {
            organizationService.insert(organization);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--OrganizationController--addOrganization--添加部门失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 更新部门
     * @param organization 部门对象
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage editOrganization(Organization organization) {
        BackMessage message = new BackMessage();
        try {
            organizationService.update(organization);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--OrganizationController--editOrganization--更新部门失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 删除部门
     * @param id 部门ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage deleteOrganization(@RequestParam(value = "id", required = true, defaultValue = "") String id) {
        BackMessage message = new BackMessage();
        try {
            organizationService.delelte(id);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--OrganizationController--deleteOrganization--删除部门失败--{}--", e.getMessage(), e);
        }
        return message;
    }
}

package com.cnesa.authority.controller;

import base.BaseController;
import com.cnesa.authority.entity.Role;
import com.cnesa.common.model.EasyuiPage;
import com.cnesa.authority.service.RoleService;
import com.cnesa.common.model.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 角色操作
 *
 * Created by shangpeibao on 16/12/8.
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色列表
     * @param page 当前爷
     * @param rows 返回记录行
     * @param sort 排序列名
     * @param order 排序方式
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage dataGrid(Integer page, Integer rows, String sort, String order) {
        BackMessage message = new BackMessage();
        EasyuiPage easyuiPage = new EasyuiPage(page, rows, sort, order);
        Map<String, Object> condition = new HashMap<String, Object>();
        try {
            easyuiPage.setCondition(condition);
            roleService.selectDataGrid(easyuiPage);
            message.setData(easyuiPage);
            message.setSuccess(true);
        } catch (Exception e) {
            message.setError(e.getMessage());
            logger.error("--RoleController--dataGrid--获取角色列表失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 保存角色
     * @param role 角色对象
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage addRole(Role role) {
        BackMessage message = new BackMessage();
        try {
            roleService.insert(role);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--RoleController--addRole--保存角色失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 更新角色
     * @param role 角色对象
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage editRole(Role role) {
        BackMessage message = new BackMessage();
        try {
            roleService.update(role);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--RoleController--editRole--编辑角色失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage deleteRole(@RequestParam(value = "id", required = true, defaultValue = "") String id) {
        BackMessage message = new BackMessage();
        try {
            roleService.delete(id);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--RoleController--deleteRole--删除角色失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 通过角色ID 获取已绑定的权限IDs
     * @param roleId 角色ID
     * @return
     */
    @RequestMapping(value = "/findResourceIdListByRoleId", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage findResourceIdListByRoleId(@RequestParam(value = "id", required = true, defaultValue = "") String roleId) {
        BackMessage message = new BackMessage();
        try {
            message.setData(roleService.selectResourceIdListByRoleId(roleId));
            message.setSuccess(true);
        } catch (Exception e) {
            message.setError(e.getMessage());
            logger.error("--RoleController--findResourceIdListByRoleId--获取已绑定的权限失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 角色授权
     * @param roleId  角色ID
     * @param menuIds 资源菜单IDs
     * @return
     */
    @RequestMapping(value = "/grant", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage grantRole(@RequestParam(value = "id", required = true, defaultValue = "") String roleId,
                             @RequestParam(value = "resourceIds", required = false) String menuIds) {
        BackMessage message = new BackMessage();
        try {
            roleService.updateRoleMenu(roleId, menuIds);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--RoleController--grantRole--角色授权失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 获取角色树
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    @ResponseBody
    public Object roleTree() {
        try {
            return roleService.selectRoleTree();
        } catch (Exception e) {
            logger.error("--RoleController--roleTree--获取角色树失败--{}--", e.getMessage(), e);
        }
        return null;
    }
}

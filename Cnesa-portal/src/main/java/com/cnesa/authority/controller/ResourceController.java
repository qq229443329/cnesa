package com.cnesa.authority.controller;

import base.BaseController;
import com.cnesa.authority.common.AuthorityConstant;
import com.cnesa.authority.entity.Menu;
import com.cnesa.authority.entity.User;
import com.cnesa.authority.service.MenuService;
import com.cnesa.common.model.BackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shangpeibao on 16/12/7.
 *
 * 资源菜单管理
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * 资源树（不包括按钮）
     * @return
     */
    @RequestMapping(value = "/menuTree", method = RequestMethod.POST)
    @ResponseBody
    public Object menuTree() {
        try {
            User user = getCurrentUser();
            return menuService.selectMenuTreeByUser(user);
        } catch (Exception e) {
            logger.error("--ResourceController--menuTree--查询资源树失败--{}--", e.getMessage(), e);
        }
        return null;
    }

    /**
     * 资源树（不包括按钮）
     * @return
     */
    @RequestMapping(value = "/resourceTree", method = RequestMethod.POST)
    @ResponseBody
    public Object resourceTree() {
        try {
            User user = getCurrentUser();
            return menuService.selectResourceTreeByUser(user);
        } catch (Exception e) {
            logger.error("--ResourceController--resourceTree--查询资源树失败--{}--", e.getMessage(), e);
        }
        return null;
    }


    /**
     * 获取所有资源树列表
     * @return
     */
    @RequestMapping(value = "/treeGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object treeGrid() {
        try {
            return menuService.selectAllTreeGrid();
        } catch (Exception e) {
            logger.error("--ResourceController--treeGrid--查询资源列表失败--{}--", e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取所有资源树结构包括按钮
     * @return
     */
    @RequestMapping(value = "/allTrees", method = RequestMethod.POST)
    @ResponseBody
    public Object allTrees() {
        try {
            return menuService.selectAllTrees();
        } catch (Exception e) {
            logger.error("--ResourceController--allTrees--查询资源全树失败--{}--", e.getMessage(), e);
        }
        return null;
    }

    /**
     * 添加资源
     * @param menu 资源对象
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage addResource(Menu menu) {
        BackMessage message = new BackMessage();
        try {
            menuService.insert(menu);
            message.setSuccess(true);
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--ResourceController--addResource--保存资源菜单失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 删除资源
     * @param id 资源ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage deleteResource(String id) {
        BackMessage message = new BackMessage();
        try {
            menuService.delete(id);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--ResourceController--deleteResource--删除资源菜单失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 修改资源
     * @param menu 资源对象
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage editResource(Menu menu) {
        BackMessage message = new BackMessage();
        try {
            menuService.update(menu);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setMsg("操作失败!");
            message.setError(e.getMessage());
            logger.error("--ResourceController--editResource--编辑资源菜单失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 所有菜单类型树
     * @return
     */
    @RequestMapping(value = "/allMenuTree", method = RequestMethod.POST)
    @ResponseBody
    public Object allMenuTree() {
        try {
            return menuService.selectAllMenuTrees(AuthorityConstant.MENU_FUNCTION_MENU);
        } catch (Exception e) {
            logger.error("--ResourceController--allMenuTree--查询所有菜单资源全树失败--{}--", e.getMessage(), e);
        }
        return null;
    }
}

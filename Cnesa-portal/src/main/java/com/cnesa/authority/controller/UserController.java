package com.cnesa.authority.controller;

import base.BaseController;
import com.cnesa.authority.entity.User;
import com.cnesa.common.model.EasyuiPage;
import com.cnesa.authority.service.UserService;
import com.cnesa.common.model.BackMessage;
import com.cnesa.common.utils.DigestUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by shangpeibao on 16/12/7.
 *
 * 用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 获取用户树列表
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object dataGrid(User user, Integer page, Integer rows, String sort, String order, String organizationId) {
        try {
            EasyuiPage easyuiPage = new EasyuiPage(page, rows, sort, order);
            Map<String, Object> conditions = new HashedMap();
            conditions.put("orgId", organizationId);
            if (StringUtils.hasLength(user.getUsername())) {
                conditions.put("username", user.getUsername());
            }
            if (user.getOrgId() != null) {
                conditions.put("orgId", user.getOrgId());
            }
            if (user.getCreatedateStart() != null) {
                conditions.put("startTime", user.getCreatedateStart());
            }
            if (user.getCreatedateEnd() != null) {
                conditions.put("endTime", user.getCreatedateEnd());
            }
            easyuiPage.setCondition(conditions);
            userService.selectDataGrid(easyuiPage);
            return easyuiPage;
        } catch (Exception e) {
            logger.error("--UserController--dataGrid--获取用户树列表失败--{}--", e.getMessage(), e);
        }
        return null;
    }

    /**
     * 用户添加
     * @param user 用户对象
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage addUser(User user) {
        BackMessage message = new BackMessage();
        try {
            if (user == null) {
                message.setMsg("未填写任何信息!");
                return message;
            }
            if (!StringUtils.hasLength(user.getUsername())) {
                message.setMsg("登录名不能为空!");
                return message;
            }
            if (!StringUtils.hasLength(user.getPassword())) {
                message.setMsg("密码不能为空!");
                return message;
            }

            List<User> userList = userService.selectByUser(user);
            if (userList != null && !userList.isEmpty()) {
                message.setMsg("用户名已存在!");
                return message;
            }
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            userService.insert(user);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setError(e.getMessage());
            message.setMsg("操作失败!");
            logger.error("--UserController--addUser--添加用户失败--{}--", e.getMessage(), e);
        }
        return message;
    }
    /**
     * 编辑用户
     * @param user  用户对象
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage editUser(User user) {
        BackMessage message = new BackMessage();
        try {
            if (user == null || !StringUtils.hasLength(user.getUsername())) {
                message.setMsg("用户或密码不能为空!");
                return message;
            }

            List<User> userList = userService.selectByUser(user);
            if (userList != null && !userList.isEmpty()) {
                message.setMsg("用户名已存在!");
                return message;
            }
            userService.upddate(user);
            message.setSuccess(true);
            message.setMsg("操作成功!");
        } catch (Exception e) {
            message.setError(e.getMessage());
            message.setMsg("操作失败!");
            logger.error("--UserController--editUser--更新用户失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BackMessage deleteUser(String id) {
        BackMessage message = new BackMessage();
        try {
            String currentUserId = getCurrentUser().getId();
            if (currentUserId.equals(id)) {
                message.setMsg("禁止删除自己账户！");
            } else {
                message.setSuccess(userService.deleteUser(id));
                message.setMsg("操作成功!");
            }
        } catch (Exception e) {
            message.setError(e.getMessage());
            message.setMsg("操作失败!");
            logger.error("--UserController--deleteUser--删除用户失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 修改密码
     *
     * @param oldPwd
     * @param pwd
     * @return
     */
    @RequestMapping("/editUserPwd")
    @ResponseBody
    public Object editUserPwd(String oldPwd, String pwd) {
        BackMessage message = new BackMessage();
        try {
            User currentUser = getCurrentUser();
            if (!currentUser.getPassword().equals(DigestUtils.md5Hex(oldPwd))) {
                message.setMsg("旧密码不正确!");
            }
            userService.updatePwdByUserId(currentUser.getId(), DigestUtils.md5Hex(pwd));
            message.setMsg("密码修改成功!");
            message.setSuccess(true);
        } catch (Exception e) {
            message.setMsg("修改密码失败!");
            logger.error("--UserController--editUserPwd--修改密码失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 重置用户密码
     * @param userId 用户ID
     * @param pwd 新密码
     * @return
     */
    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
    @ResponseBody
    public Object resetPwd(String userId, String pwd) {
        BackMessage message = new BackMessage();
        try {
            if (StringUtils.hasLength(userId) && StringUtils.hasLength(pwd)) {
                userService.updatePwdByUserId(userId, DigestUtils.md5Hex(pwd));
                message.setMsg("设置密码成功!");
                message.setSuccess(true);
            } else {
                message.setMsg("未找到用户或密码为空!");
            }
        } catch (UnsupportedEncodingException e) {
            message.setMsg("重置密码失败!");
            logger.error("--UserController--editUserPwd--修改密码失败--{}--", e.getMessage(), e);
        }
        return message;
    }

}

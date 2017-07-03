package com.cnesa.web.controller;

import base.BaseController;
import com.cnesa.authority.model.CurrentUser;
import com.cnesa.authority.service.UserService;
import com.cnesa.common.model.BackMessage;
import com.cnesa.common.utils.TokenUtil;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.UUID;

/**
 * Created by shangpeibao on 16/12/19.
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/web")
public class WebLoginController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(WebLoginController.class);

    @Autowired
    UserService userService;

    /**
     * 获取uuid
     * @return
     */
    @RequestMapping(value = "/getSession", method = RequestMethod.POST)
    public BackMessage getUUID() {
        BackMessage message = new BackMessage();
        message.setSuccess(true);
        String uuid = UUID.randomUUID().toString();
        message.setData(uuid);
        System.out.println(uuid);
        return message;
    }

    /**
     * 用户登录
     * @param username  用户名
     * @param password  密码
     * @param uid  sessionid
     * @param verifyCode  验证码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BackMessage webLogin(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam(value = "uid", required = true) String uid,
                                @RequestParam("verifyCode") String verifyCode,
                                HttpServletRequest request) {
        BackMessage message = new BackMessage();
        try {
            if (!StringUtils.hasLength(username)) {
                message.setMsg("用户名不能为空!");
                return message;
            }
            if (!StringUtils.hasLength(password)) {
                message.setMsg("密码不能为空!");
                return message;
            }
//            String verifycode = redisOpsService.getValueByRedisKey(uid);
//            if (verifycode != null && verifycode.equals(verifyCode.toUpperCase())) {
//                try {
//                    String token = userService.selectLoginByUsername(username, password);
//                    message.setToken(token);
//                    String userId = TokenUtil.getUserIdByToken(token);
//                    List<ProjectInfo> projectInfoList = projectInfoService.selectPByUserId(userId);
//                    request.getSession().setAttribute("token", token);
//                    message.setData(projectInfoList);
//                    message.setSuccess(true);
//                    messageService.insertMessage(userId, "登录");
//                    return message;
//                } catch (UnknownAccountException e) {
//                    message.setMsg("账号不存在或已冻结！");
//                    logger.error("账号不存在或已冻结！", e);
//                } catch (DisabledAccountException e) {
//                    message.setMsg("账号未启用！");
//                    logger.error("账号未启用！", e);
//                } catch (IncorrectCredentialsException e) {
//                    message.setMsg("密码错误！");
//                    logger.error("密码错误！", e);
//                } catch (NumberFormatException e) {
//                    message.setMsg("数据推送错误！");
//                    logger.error("数据推送错误！", e);
//                } catch (ParseException e) {
//                    message.setMsg("数据推送错误！");
//                    logger.error("数据推送错误！", e);
//                } catch (RedisSystemException e) {
//                    message.setMsg("静态数据推送错误！");
//                    logger.error("静态数据推送错误！", e);
//                } catch (Exception e) {
//                    message.setMsg("未知错误,请联系管理员！");
//                    logger.error("未知错误,请联系管理员！", e);
//                }
//            } else {
//                message.setMsg("验证码错误！");
//            }
        } catch (Exception e) {
            logger.error("--LoginController--login--登录失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public BackMessage webLogout(HttpServletRequest request) {
        BackMessage message = new BackMessage();
        String userId = CurrentUser.getId();
        try {
//            messageService.insertMessage(userId, "退出");
            userService.deleteToken(userId);
            // 销毁session
            request.getSession().invalidate();
            message.setSuccess(true);

        } catch (Exception e) {
            message.setError(e.getMessage());
            logger.error("--LoginController--webLogout--退出登录失败--{}--", e.getMessage(), e);
        }
        return message;
    }

}

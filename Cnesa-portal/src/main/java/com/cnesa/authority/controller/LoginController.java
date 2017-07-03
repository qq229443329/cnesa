package com.cnesa.authority.controller;

import base.BaseController;
import com.cnesa.common.model.BackMessage;
import com.cnesa.common.utils.DigestUtils;
import com.cnesa.common.utils.VerifyCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by shangpeibao on 16/12/2.
 *
 * 登陆操作
 */
@Controller
public class LoginController extends BaseController {

    private static Map<String, String> verifyCodes = new HashMap<>();

    /**
     * 响应返回登录页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/authority/index";
        }
        model.addAttribute("uid", UUID.randomUUID());
        return "login";
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
    @ResponseBody
    public BackMessage login(@RequestParam("username") String username,
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

            String verifycode = verifyCodes.get(uid);
            if (verifycode != null && verifycode.equals(verifyCode.toUpperCase())) {
                verifyCodes.remove(uid);
                Subject user = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5Hex(password));
                // 默认设置为记住密码，你可以自己在表单中加一个参数来控制
                token.setRememberMe(true);
                try {
                    user.login(token);
                    request.getSession().setAttribute("user", user);
                    message.setSuccess(true);
                    return message;
                } catch (UnknownAccountException e) {
                    message.setMsg("账号不存在或已冻结！");
                    logger.error("账号不存在或已冻结！", e);
                } catch (DisabledAccountException e) {
                    message.setMsg("账号未启用！");
                    logger.error("账号未启用！", e);
                } catch (IncorrectCredentialsException e) {
                    message.setMsg("密码错误！");
                    logger.error("密码错误！", e);
                } catch (Throwable e) {
                    message.setMsg("未知错误,请联系管理员！");
                    logger.error("未知错误,请联系管理员！", e);
                }
            } else {
                message.setMsg("验证码错误！");
            }
        } catch (Exception e) {
            logger.error("--LoginController--login--登录失败--{}--", e.getMessage(), e);
        }
        return message;
    }

    /**
     * 生成验证码
     * @param uid
     */
    @RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
    public void createVerifyCode(HttpServletResponse response, @RequestParam(value = "uid", required = true) String uid) {
        int w = 100, h = 40;
        ServletOutputStream sos = null;
        try {
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            verifyCodes.put(uid, verifyCode);
            // 禁止图像缓存。
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            // 将图像输出到Servlet输出流中。
            sos = response.getOutputStream();
            VerifyCodeUtils.outputImage(w, h, sos, verifyCode);
            sos.close();
        } catch (IOException e) {
            logger.error("--LoginController--createVerifyCode--生成验证码失败--{}--", e.getMessage(), e);
        } finally {
            if (sos != null) {
                try {
                    sos.close();
                } catch (IOException e) {
                    logger.error("--LoginController--createVerifyCode--关闭输出流失败--{}--", e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 退出
     * @return {Result}
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Object logout(HttpServletRequest request) {
        BackMessage message = new BackMessage();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            request.getSession().invalidate();
            message.setSuccess(true);
        } catch (Exception e) {
            logger.error("--LoginController--logout--用户退出失败--{}--", e.getMessage(), e);
        }
        return message;
    }

}

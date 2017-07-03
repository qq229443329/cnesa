package com.cnesa.authority.controller;

import base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shangpeibao on 16/12/2.
 *
 *  处理页面跳转
 */
@Controller
public class PagesController extends BaseController {

    /**
     * 默认跳转到登录页面
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

}

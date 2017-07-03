package com.cnesa.authority.controller;

import base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shangpeibao on 16/12/7.
 */
@Controller
public class AuthorityController extends BaseController {

    /**
     * 管理首页
     * @return
     */
    @RequestMapping(value = "/authority/index")
    public String index() {
        return "authority/index";
    }
}

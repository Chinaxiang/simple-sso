package com.simple.sso.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.sso.client.constant.AuthConst;

/**
 * 认证中心页面显示控制器
 * @author yanxiang.huang 2019-02-14 10:11:13
 */
@Controller
public class IndexController {

    /**
     * 登录页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute(AuthConst.CLIENT_URL, request.getParameter(AuthConst.CLIENT_URL));
        return "index";
    }

    /**
     * 登录成功页面
     *
     * @return
     */
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
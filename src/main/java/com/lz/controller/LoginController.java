package com.lz.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ly on 2017/9/3.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginAction")
    public String loginAction(HttpServletRequest  request) {
        String login= request.getParameter("loginname");
        String password= request.getParameter("password");
        return "login";
    }

}

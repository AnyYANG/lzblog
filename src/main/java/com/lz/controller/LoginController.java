package com.lz.controller;

import com.lz.bean.SysUser;
import com.lz.service.SysUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Ly on 2017/9/3.
 */
@Controller
public class LoginController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 跳转登陆首页
     *
     * @return 返回登陆首页
     */
    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }

    /**
     *   登陆请求
     * @param request  请求
     * @return 返回登陆结果， 登陆成功进入index 失败进入failed
     */
    @RequestMapping(value = "/loginAction")
    public String loginAction(HttpServletRequest  request) {
        String userName = request.getParameter("loginname");
        String password= request.getParameter("password");
        SysUser user = sysUserService.validateSysUser(userName, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userlogin", "isLogin");
            session.setAttribute("userSession", userName);
            session.setAttribute("user", user);
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/goindex")
    public String goIndex(HttpServletRequest  request) {

            return "index";
    }

}

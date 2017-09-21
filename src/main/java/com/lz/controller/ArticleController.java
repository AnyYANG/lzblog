package com.lz.controller;

import com.lz.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {


    @Resource
    private ArticleService articleService;
    /**
     * 跳转登陆首页
     *
     * @return 返回登陆首页
     */
    @RequestMapping(value = "/addpage")
    public String articleAddPage() {
        return "/article/editors";
    }

    /**
     * 添加文章
     *
     * @return 返回登陆首页
     */
    @RequestMapping(value = "/add")
    public String articleAdd(HttpServletRequest request) {
        try {
            String content = request.getParameter("textcontent");
            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("userSession");
            String userlogin = (String) session.getAttribute("userlogin");
            if (StringUtils.isNotBlank(userlogin)) {
                articleService.addNewArticle(userName, content);
                return "/public/success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }

}

package com.lz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    /**
     * 跳转登陆首页
     *
     * @return 返回登陆首页
     */
    @RequestMapping(value = "/addpage")
    public String articleAddPage() {
        return "editors";
    }


}

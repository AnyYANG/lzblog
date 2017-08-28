package org.spring.springboot.controller;

import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  进入登陆页面
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String findOneCity() {
        return "index";
    }
}

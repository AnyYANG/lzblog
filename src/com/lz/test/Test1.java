package com.lz.test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ly on 2017/7/24.
 */


@RestController
public class Test1 {
    @RequestMapping("/test")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Test1.class, args);
    }
    @RequestMapping("/test1")
    String indexPage() {
        return "/index.jsp";
    }

}

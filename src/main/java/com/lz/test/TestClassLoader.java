package com.lz.test;

import com.lz.Application;
import com.lz.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestClassLoader {
    @Resource
    private SysUserService sysUserService;

    @Test
    public void getClassPath() {
        URL path = this.getClass().getClassLoader().getResource("ariticle/a.txt");
        System.out.println("path:" + path.toString());
    }
}

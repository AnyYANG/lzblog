package com.lz.test;

import com.lz.Application;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

public class TestClassLoader {

    @Test
    public void getClassPath() {
        URL path = this.getClass().getClassLoader().getResource("ariticle/a.txt");
        System.out.println("path:" + path.toString());
    }
}

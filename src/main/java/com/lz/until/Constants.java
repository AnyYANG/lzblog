package com.lz.until;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.net.URL;

/**
 * 系统常量
 */
@Component
@Order(value = 2)
public class Constants implements CommandLineRunner {

    private static String classPath;

    public static String getClassPath() {
        return classPath;
    }

    @Override
    public void run(String... args) throws Exception {
        URL path = this.getClass().getClassLoader().getResource("");
        classPath = path.toString();
    }
}

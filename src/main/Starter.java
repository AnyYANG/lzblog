package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ly on 2017/8/1.
 *  用启动项目
 */
@EnableAutoConfiguration
@SpringBootApplication
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
    @RequestMapping("/test")
    String home() {
        return "Hello World!";
    }

}

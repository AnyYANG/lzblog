package com.lz.until;

import com.lz.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import  org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Todo  war包启动类  未配置完成
 */
class  ServletInit extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}

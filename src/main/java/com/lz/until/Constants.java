package com.lz.until;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${constants.fileFolder}")
    private String fileFolder;
    private static String classPath;
    private static String shellPath;
    public static String getClassPath() {
        return classPath;
    }

    public String getFileFolder() {
        return fileFolder;
    }

    @Override
    public void run(String... args) throws Exception {
        URL path = this.getClass().getClassLoader().getResource("");
        classPath = path.toString();
    }

    public String getShellPath(String shellScriptFileName) {
        if(StringUtils.isNotBlank(shellPath)){
           return shellPath;
        }else{
            shellPath=classPath+"/shell/"+shellScriptFileName;
           return shellPath;
        }
    }
}

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

    /**
     * 文章文件夹
     */
    @Value("${constants.fileFolder}")
    private String fileFolder;
    /**
     * 用户列表位置
     */
    @Value("${constants.userListFile}")
    private String userListFile;
    @Value("${constants.shellDir}")
    private  String shellPath;

    private  String classPath;
    public  String getClassPath() {
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
           return shellPath+shellScriptFileName;
    }
    public String getUserList() {
        return userListFile;
    }
}

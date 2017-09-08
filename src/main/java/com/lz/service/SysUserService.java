package com.lz.service;

import com.lz.bean.SysUser;
import com.lz.until.FileUntil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ly on 2017/9/4.
 */
@Service
public class SysUserService {
    private static Map<String, SysUser> userMap = new HashMap<String, SysUser>();
    protected Logger log = Logger.getLogger(SysUserService.class);
    @PostConstruct
    public void init() {
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();  //获取类加载器
            URL url = classLoader.getResource("user.txt");  //获取资源文件
            System.out.println(url.getFile()); //打印出文件路径
            File userFile = new File(url.getFile());//获得文件
            List<String> userStringList = FileUntil.readFileByLines(userFile);
            createUserMap(userStringList);
        } catch (Exception e) {
            //Todo  log err exception
        }
    }

    /**
     * 要查询的用户名称
     *
     * @param userName  用户的登陆名
     * @return 返回用户对象
     */
    public SysUser findOneSysUser(String userName) {
        return userMap.get(userName);
    }

    /**
     * 数据格式1@liuyang@1234679@刘洋@/src/liuyang.jpg/123.123.123.123/2017年9月8日
     *
     * @param userList 用户的列表
     */
    public void createUserMap(List<String> userList) {
        System.err.println("创建用户列表");
        if (userList != null && userList.size() > 0) {
            for (String user : userList) {
                SysUser sysuser = new SysUser();
                if (StringUtils.isNotBlank(user)) {
                    String temp[] = user.split("@");
                    sysuser.setId("" + temp[0]);
                    sysuser.setUsername("" + temp[1]);
                    sysuser.setPassword("" + temp[2]);
                    sysuser.setImgsrc("" + temp[3]);
                    sysuser.setLoginipHistory("" + temp[4]);
                    sysuser.setLastLoginTimes("" + temp[5]);
                    userMap.put(temp[1], sysuser);
                    System.err.println("用户" + temp[0] + temp[1] + temp[2] + temp[3] + temp[4] + temp[5]);
                }

            }
        }
    }

    /**
     * 验证用户登陆合法性
     *
     * @param LoginName 登录名
     * @param password  密码
     * @return 如果存在返回对象，如果不存在返回null
     */
    public SysUser validateSysUser(String LoginName, String password) {
        SysUser user = userMap.get(LoginName);
        if (StringUtils.isNotBlank(LoginName) && user != null) {
            if (StringUtils.isNoneBlank()) {
                if (password.equals(user.getPassword())) {
                    return user;
                }
            }
        }
        return null;
    }
}

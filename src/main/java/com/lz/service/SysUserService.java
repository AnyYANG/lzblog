package com.lz.service;

import com.lz.bean.SysUser;
import com.lz.until.Constants;
import com.lz.until.FileUntil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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
    @Resource
    Constants constants;
    //   protected Logger log = Logger.getLogger(SysUserService.class);
    @PostConstruct
    public void init() {
        try {
            String url =constants.getUserList();
            File userFile = new File(url);//获得文件
            List<String> userStringList = FileUntil.readFileByLines(userFile);
            createUserMap(userStringList);
        } catch (Exception e) {
            e.printStackTrace();
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
                    sysuser.setLoginName(""+temp[1]);
                    sysuser.setPassword("" + temp[2]);
                    sysuser.setUsername("" + temp[3]);
                    sysuser.setImgsrc("" + temp[4]);
                    sysuser.setLoginipHistory("" + temp[5]);
                    sysuser.setLastLoginTimes("" + temp[6]);
                    userMap.put(temp[1], sysuser);
                    //            System.err.println("用户" + temp[0] + temp[1] + temp[2] + temp[3] + temp[4] + temp[5]);
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

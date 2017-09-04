package com.lz.bean;

/**
 * Created by Ly on 2017/9/3.
 */
public class SysUser {
    private  String  id;   //序号
    private  String  loginName;  //登陆账号
    private  String  password;   //密码
    private  String  username;  //用户名
    private  String  imgsrc;   //个人头像url
    private  String  loginipHistory;  //历史登陆ip记录
    private  String  loginTimes;  //登陆次数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getLoginipHistory() {
        return loginipHistory;
    }

    public void setLoginipHistory(String loginipHistory) {
        this.loginipHistory = loginipHistory;
    }

    public String getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(String loginTimes) {
        this.loginTimes = loginTimes;
    }
}

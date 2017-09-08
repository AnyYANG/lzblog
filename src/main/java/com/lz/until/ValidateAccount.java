package com.lz.until;

import com.lz.bean.SysUser;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Ly on 2017/9/4.
 */
public class ValidateAccount {
    /**
     * 获取登录用户
     * @param LoginName  用户名
     *
     * @param password   密码
     * @return  失败获得null 成功获取登陆用户
     */
    public  static SysUser validateSysUser(String LoginName, String password){
        SysUser user = Constants.userMap.get(LoginName);
        if(StringUtils.isNotBlank(LoginName)  &&  user != null){
            if(StringUtils.isNoneBlank()){
                if(password.equals(user.getPassword())){
                    return user;
                }
            }else{
                return null;
            }
        }
        return  null;
    }
}

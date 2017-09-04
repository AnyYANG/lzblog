package com.lz.until;

import com.lz.bean.SysUser;
import org.apache.commons.lang3.StringUtils;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ly on 2017/9/4.
 */
public class Constants {

     public  static Map<String,SysUser> userMap= new HashMap<String,SysUser>();
     public Constants() {
     }
     @PostConstruct
     public void init(){


     }
}

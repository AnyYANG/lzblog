package com.lz.until;

import com.lz.bean.SysUser;
import org.apache.commons.lang3.StringUtils;


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
public class Constants {

     public  static Map<String,SysUser> userMap= new HashMap<String,SysUser>();
     public Constants() {


     }
     @PostConstruct
     public void init(){
          ClassLoader classLoader = this.getClass().getClassLoader();  //获取类加载器
          URL url = classLoader.getResource("user.txt");  //获取资源文件
          System.out.println(url.getFile()); //打印出文件路径
          File userFile = new File(url.getFile());//获得文件
         List<String> userStringList = FileUntil.readFileByLines(userFile);

     }

}

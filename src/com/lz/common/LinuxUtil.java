package com.lz.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Ly on 2017/7/27.
 *  用来执行命令
 */
public class LinuxUtil {

    public static String execSH(String dir){
        String result ="";
        try {
            Process ps = Runtime.getRuntime().exec(dir);
            ps.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("-");
            }
            result = sb.toString();
         System.out.print("****"+result+"****");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }
}

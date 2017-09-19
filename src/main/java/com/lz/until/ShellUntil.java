package com.lz.until;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellUntil {
    public static String runShell(String  path){
        try {
            String shpath=path;
            Process ps = Runtime.getRuntime().exec(shpath);
            ps.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "end";
    }
}
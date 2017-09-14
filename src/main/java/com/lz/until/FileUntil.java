package com.lz.until;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Ly on 2017/9/3.
 */
public class FileUntil {

    /**
     * 遍历一个目录 返回md文件目录列表
     *
     * @param path 文件目录
     * @return md文件列表
     */
    public Iterator<File> iteratorFolder(String path) {
        File file = new File(path);
        String[] extensions = new String[]{"md"};
        IOFileFilter filter = new SuffixFileFilter(extensions, IOCase.INSENSITIVE);
        Iterator<File> iterator = FileUtils.iterateFiles(file, filter, DirectoryFileFilter.DIRECTORY);
        return iterator;
    }


    /**
     * 创建一个markdown 文件
     *
     * @param filename   文件名
     * @param content 文件内容
     * @return 返回文件名
     */
    public static String CreateFile(String filename, String content, String path) {
        try {
            String filePath = path + "/" + filename + ".md";
            System.out.println("filePath:" + filePath);
            File file = new File(filePath);
            FileUtils.writeStringToFile(file, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static List<String> readFileByLines(File file) {
        //File file = new File(fileName);
        BufferedReader reader = null;
        List<String> userString= new ArrayList<String>();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                userString.add(tempString);//将String 数组读入，并返回到用户列表数组
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    System.out.println("文件读入异常！ Exception"+ e1.getMessage());
                }
            }
        }
        return userString;
    }

    /**
     * 获取classpath的根目录
     * @param fileName
     * @return
     */
    public File getPath(String fileName){
        ClassLoader classLoader = this.getClass().getClassLoader();
        /**
         getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
         */
        URL url = classLoader.getResource(fileName);
        /**
         * url.getFile() 得到这个文件的绝对路径
         */
        System.out.println(url.getFile());
        File file = new File(url.getFile());
        return file;
        //System.out.println(file.exists());
    }


    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public  void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]){

        FileUntil fu= new FileUntil();
        File file = fu.getPath("user.txt");
        readFileByLines(file);
    }

}

package com.lz.service;


import com.lz.until.Constants;
import com.lz.until.FileUntil;
import com.lz.until.ShellUntil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.URL;
import java.util.Date;

@Service
public class ArticleService {
    @Resource
    Constants constants;

    /**
     * 增加一篇新的文章
     *
     * @param content 文章内容
     * @return 返回是否添加成功
     */
    public boolean addNewArticle(String username, String content) {
        if (StringUtils.isNotBlank(content) && StringUtils.isNotBlank(username)) {
            String filename = username + "_" + System.currentTimeMillis();
            String path = constants.getFileFolder() + "article";
            // 保存文件
            String fileName = FileUntil.CreateFile(filename, content, path);
            //运行hexo  更新网站
            ShellUntil.runShell(constants.getShellPath("hexoGenerate.sh"));
            return true;
        } else {
            return false;
        }
    }

}

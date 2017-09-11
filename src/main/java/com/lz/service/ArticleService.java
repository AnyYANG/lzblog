package com.lz.service;


import com.lz.until.FileUntil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticleService {

    /**
     * 增加一篇新的文章
     *
     * @param content 文章内容
     * @return 返回是否添加成功
     */
    public boolean addNewArticle(String username, String content) {
        if (StringUtils.isNotBlank(content) && StringUtils.isNotBlank(username)) {
            String title = username + "_" + System.currentTimeMillis();
            String fileName = FileUntil.CreateFile(title, content);
            return true;
        } else {
            return false;
        }
    }
}

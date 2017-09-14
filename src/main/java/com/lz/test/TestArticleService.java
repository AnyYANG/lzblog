package com.lz.test;

import com.lz.service.ArticleService;

import com.lz.until.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestArticleService {
    @Resource
    private ArticleService articleService;
    @Resource
    private Constants constants;


    @Test
    public void testArticleAdd() {
        articleService.addNewArticle("liuyang", "liuyangadasdfasdfdfdjfejfiefjeifjeifiefjiejfeifeijfeifeifjeijfewfe");
    }
}

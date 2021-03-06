package com.lz.test;

import com.lz.until.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 *   TestCaseUnit   Test  get correct shell file path
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestConstants {
    @Resource
    Constants  constants;
    @Test
    public void testGetClassPathShellFile(){
    String path = constants.getShellPath("hexoGenerate.sh");
    System.out.println(path);
    Assert.notNull(path,"success");
    }

}

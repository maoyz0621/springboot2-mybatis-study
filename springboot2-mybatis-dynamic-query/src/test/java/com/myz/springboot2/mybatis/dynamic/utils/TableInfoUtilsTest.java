package com.myz.springboot2.mybatis.dynamic.utils;


import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author maoyz0621 on 2024/7/30
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableInfoUtilsTest {

    @Test
    public void getTableInfo() {
    }

    @Test
    public void testGetTableInfo() {
        TableInfo user = TableInfoUtils.getTableInfo("user");
    }
}
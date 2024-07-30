package com.myz.springboot2.mybatisplus.sqlite.utils;


import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.myz.springboot2.mybatis.dynamic.utils.TableInfoUtils;
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
        TableInfo tableInfo = TableInfoUtils.getTableInfo("user");
        System.out.println(tableInfo.getTableName());
        System.out.println(tableInfo.getFieldList());
        System.out.println(tableInfo.getKeyColumn());
    }
}
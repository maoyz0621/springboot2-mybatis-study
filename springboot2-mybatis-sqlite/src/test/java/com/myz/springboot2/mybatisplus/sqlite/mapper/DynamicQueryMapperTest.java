package com.myz.springboot2.mybatisplus.sqlite.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.collect.Lists;
import com.myz.springboot2.mybatis.dynamic.mapper.DynamicQueryMapper;
import com.myz.springboot2.mybatisplus.sqlite.MybatisSqliteApplication;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author maoyz0621 on 2024/5/20
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisSqliteApplication.class)
public class DynamicQueryMapperTest {

    @Autowired
    DynamicQueryMapper dynamicQueryMapper;

    @BeforeClass
    public static void before() {
        System.setProperty("sqlite.home", "E:\\WorkWare\\sqlite");
    }

    @Test
    public void select() {
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        // 查询where
        queryWrapper.eq("id", "2");
        // 查询column
        queryWrapper.select("id", "username");
        // select id,username from user WHERE (id = ?)
        List<Map<String, Object>> user = dynamicQueryMapper.select("user", queryWrapper);
        System.out.println(user);
    }

    @Test
    public void selectLargeData() {

    }

    @Test
    public void update() {
        UpdateWrapper<Object> updateWrapper = new UpdateWrapper<>();
        // 查询where
        updateWrapper.eq("id", "2");
        updateWrapper.set("username", "hehe");
        // update user set username=? WHERE (id = ?)
        int count = dynamicQueryMapper.update("user", updateWrapper);
        assert count == 1;
    }

    @Test
    public void delete() {
    }

    @Test
    public void insert() {
        ArrayList list = Lists.newArrayList("2", "haha", 10);
        // insert into user (id,username,age) values ( ? , ? , ? )
        int count = dynamicQueryMapper.insert("user", "id,username,age", list);
        assert count == 1;
    }

    @Test
    public void count() {
    }
}
package com.myz.springboot2.mybatisplus.sqlite.service;

import com.myz.springboot2.mybatisplus.sqlite.entity.SqliteUserPo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


/**
 * springboot版本2.4之后，只支持JUnit5，不支持JUnit4，无需添加@RunWith
 * <p>
 * springboot版本2.2-2.4，默认使用JUnit5，同时兼容JUnit4.所以如果添加@RunWith，那么在使用@Test注解导入依赖的时候记得导入org.junit.Test;如果不添加@RunWIth，那么在使用@Test注解导入依赖的时候记得导入org.junit.jupiter.api.Test
 * junit5:@BeforeAll;
 * junit4:@BeforeClass
 *
 * @author maoyz0621 on 2024/5/20
 * @version v1.0
 */
@SpringBootTest
@Rollback(true)
public class SqliteUserServiceImplTest {

    @Autowired
    ISqliteUserService sqliteUserService;

    @BeforeAll
    public static void before() {
        System.setProperty("sqlite.home", "E:\\WorkWare\\sqlite");
    }

    @Test
    public void selectList() {
        List<SqliteUserPo> sqliteUserPos = sqliteUserService.selectList();
        System.out.println(sqliteUserPos);
    }

    @Test
    public void save() {
        SqliteUserPo sqliteUserPo = new SqliteUserPo();
        sqliteUserPo.setId(10L);
        sqliteUserPo.setUsername("112");
        sqliteUserPo.setAge(20);
        sqliteUserService.save(sqliteUserPo);

        SqliteUserPo select = sqliteUserService.getById(10L);
        System.out.println(select);

    }
}
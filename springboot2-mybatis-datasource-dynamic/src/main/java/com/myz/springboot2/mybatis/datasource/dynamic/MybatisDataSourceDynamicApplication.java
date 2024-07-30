/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatis.datasource.dynamic;

import com.myz.springboot2.mybatis.datasource.dynamic.service.MasterService;
import com.myz.springboot2.mybatis.datasource.dynamic.service.SqliteService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author maoyz0621 on 2024/5/24
 * @version v1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
@MapperScan("com.myz.springboot2.mybatis.*")
public class MybatisDataSourceDynamicApplication implements ApplicationRunner {

    public static void main(String[] args) {
        try {
            System.setProperty("sqlite.home", "E:\\WorkWare\\sqlite");
            SpringApplication.run(MybatisDataSourceDynamicApplication.class, args);
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @Autowired
    MasterService masterService;

    @Autowired
    SqliteService sqliteService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        masterService.selectAll();
        sqliteService.selectAll();
    }
}
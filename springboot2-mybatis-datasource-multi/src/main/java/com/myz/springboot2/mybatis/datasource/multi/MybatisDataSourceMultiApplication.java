/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatis.datasource.multi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author maoyz0621 on 2024/5/22
 * @version v1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class MybatisDataSourceMultiApplication {

    public static void main(String[] args) {
        try {
            System.setProperty("sqlite.home", "E:\\WorkWare\\sqlite");
            SpringApplication.run(MybatisDataSourceMultiApplication.class, args);
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
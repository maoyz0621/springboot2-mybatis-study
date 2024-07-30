/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatis.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author maoyz0621 on 2024/5/20
 * @version v1.0
 */
@SpringBootApplication
@Slf4j
public class MybatisDynamicQueryApplication {

    public static void main(String[] args) {
        try {
            System.setProperty("sqlite.home", "E:\\WorkWare\\sqlite");
            SpringApplication.run(MybatisDynamicQueryApplication.class, args);
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
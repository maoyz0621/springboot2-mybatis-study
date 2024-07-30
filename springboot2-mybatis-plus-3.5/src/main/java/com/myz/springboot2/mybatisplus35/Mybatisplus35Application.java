package com.myz.springboot2.mybatisplus35; /**
 * Copyright 2024 Inc.
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author maoyz0621 on 2024/5/20
 * @version v1.0
 */
@SpringBootApplication
@Slf4j
public class Mybatisplus35Application {

    public static void main(String[] args) {
        try {
            SpringApplication.run(Mybatisplus35Application.class, args);
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
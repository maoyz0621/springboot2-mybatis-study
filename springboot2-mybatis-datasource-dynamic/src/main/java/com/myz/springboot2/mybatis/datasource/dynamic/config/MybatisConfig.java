/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatis.datasource.dynamic.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author maoyz0621 on 2024/5/27
 * @version v1.0
 */
@Configuration
public class MybatisConfig {

    /**
     * 数据库厂商标识配置
     *
     * @return DatabaseIdProvider
     */
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("Oracle", "oracle");
        properties.setProperty("MySQL", "mysql");
        properties.setProperty("SQLServer", "mssql");
        properties.setProperty("DM DBMS", "dm");
        properties.setProperty("KingbaseES", "kingbase8");
        databaseIdProvider.setProperties(properties);

        // 关闭pagehelper的banner
        // System.setProperty("pagehelper.banner", "false");
        return databaseIdProvider;
    }
}
/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatis.datasource.multi.config;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author maoyz0621 on 2024/5/24
 * @version v1.0
 */
@Configuration
@MapperScan("com.myz.springboot2.mybatis.datasource.multi.infra.sqlite")
public class DataSourceSqliteConfig {
    static final String MAPPER_LOCATION = "com.myz.springboot2.mybatis.datasource.multi.infra.sqlite.mapper";

    /**
     * dataSource
     */
    @Bean(name = "sqliteDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.sqlite")
    public DataSource setDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 事务管理
     */
    @Bean(name = "sqliteTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("sqliteDataSource") DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    /**
     * SqlSessionFactory
     */
    @Bean(name = "sqliteSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("sqliteDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }

    /**
     * 执行批量插入
     */
    @Bean(name = "sqliteSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("sqliteSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
    }

}
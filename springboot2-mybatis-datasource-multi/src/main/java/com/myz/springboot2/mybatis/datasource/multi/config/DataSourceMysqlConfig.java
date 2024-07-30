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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author maoyz0621 on 2024/5/24
 * @version v1.0
 */
@Configuration
@MapperScan("com.myz.springboot2.mybatis.datasource.multi.infra.mysql.mapper")
public class DataSourceMysqlConfig {

    static final String MAPPER_LOCATION = "com.myz.springboot2.mybatis.datasource.multi.infra.mysql.mapper";

    /**
     * dataSource
     */
    @Bean(name = "mysqlDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.mysql")
    public DataSource setDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 事务管理
     */
    @Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    /**
     * SqlSessionFactory
     */
    @Bean(name = "mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }

    /**
     * 执行批量插入
     */
    @Bean(name = "baseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
    }
}
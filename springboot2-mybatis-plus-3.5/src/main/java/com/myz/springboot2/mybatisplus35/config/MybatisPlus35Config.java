/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatisplus35.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author maoyz0621 on 2024/5/28
 * @version v1.0
 */
@Configuration
public class MybatisPlus35Config {

    /**
     * 申明Map结果参数key值小写转换器，（oracle数据库返回的字段名称变成大写，导致和实体对象属性不一致）
     *
     * @return ConfigurationCustomizer
     */
    @Bean
    @ConditionalOnMissingBean
    public ConfigurationCustomizer configurationCustomizer() {
        return config -> {
            config.setObjectWrapperFactory(new MapWrapperFactory());
            config.getTypeHandlerRegistry().register(CustomBigDecimalTypeHandler.class);
//            config.getTypeHandlerRegistry().register(TimestampHandler.class);
            //config.setUseDeprecatedExecutor(false);
        };
    }


    /**
     * 声明mybatis拦截器
     *
     * @return MybatisPlusInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //动态表名配置
        // DynamicTableNameUtil.clear();
        DynamicTableNameInnerInterceptor tableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        tableNameInnerInterceptor.setTableNameHandler((sql, tableName) -> {

            // if (dynamicTableNames.contains(tableName)) {
            //     return DynamicTableNameUtil.getTableName(tableName);
            // }
            return tableName;
        });
        interceptor.addInnerInterceptor(tableNameInnerInterceptor);

        /*
          推荐使用PageHelper分页方式，尽量避免使用mybatis-plus自带的分页组件(Mybatis二级缓存有很多坑)。
          如果使用:
            1、分页拦截器一定要在动态表名之后，否则分页查询的动态表名不能被解析
            2、必须指定ConfigurationCustomizer.setUseDeprecatedExecutor(false)，否则分页方法二级缓存参数解析报错
         */
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

}
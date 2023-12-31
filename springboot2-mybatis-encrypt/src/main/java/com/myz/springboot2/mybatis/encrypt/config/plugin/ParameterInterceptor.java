/**
 * Copyright 2020 Inc.
 **/
package com.myz.springboot2.mybatis.encrypt.config.plugin;


import com.myz.springboot2.mybatis.encrypt.config.annotation.CryptClass;
import com.myz.springboot2.mybatis.encrypt.utils.ICrypt;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Properties;

/**
 * 参数处理拦截器
 * ParameterHandler对字段进行加密
 *
 * @author maoyz0621 on 2020/11/2
 * @version v1.0
 */
@Intercepts(
        {@Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class)})
@Slf4j
public class ParameterInterceptor implements Interceptor {

    @Autowired
    private ICrypt encryptDecrypt;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("============= 参数拦截器处理 =============");

        ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
        Object parameterObject = parameterHandler.getParameterObject();

        if (Objects.nonNull(parameterObject)) {
            Class<?> parameterObjectClass = parameterObject.getClass();
            CryptClass annotation = AnnotationUtils.findAnnotation(parameterObjectClass, CryptClass.class);

            if (Objects.nonNull(annotation)) {
                String[] filed = annotation.filed();
                // 获取注解成员
                if (filed != null) {

                }
                Field[] fields = parameterObjectClass.getDeclaredFields();

                final Object encrypt = encryptDecrypt.encrypt(fields, parameterObject);
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
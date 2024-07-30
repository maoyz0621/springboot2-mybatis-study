/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatisplus35.config;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import java.util.Map;

/**
 * @author maoyz0621 on 2024/5/28
 * @version v1.0
 */
public class MapWrapperFactory implements ObjectWrapperFactory {

    @Override
    public boolean hasWrapperFor(Object object) {
        return object instanceof Map;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        return new MapKeyLowerWrapper(metaObject, (Map<String, Object>) object);
    }
}
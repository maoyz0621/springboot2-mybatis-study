/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatisplus35.config;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;

import java.util.Map;

/**
 * @author maoyz0621 on 2024/5/28
 * @version v1.0
 */
public class MapKeyLowerWrapper extends MapWrapper {
    public MapKeyLowerWrapper(MetaObject metaObject, Map<String, Object> map) {
        super(metaObject, map);
    }

    @Override
    public String findProperty(String name, boolean useCamelCaseMapping) {
        return name == null ? "" : name.toLowerCase();
    }
}
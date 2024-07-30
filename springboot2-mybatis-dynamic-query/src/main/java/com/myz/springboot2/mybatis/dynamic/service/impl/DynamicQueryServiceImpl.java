/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatis.dynamic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.myz.springboot2.mybatis.dynamic.mapper.DynamicQueryMapper;
import com.myz.springboot2.mybatis.dynamic.service.IDynamicQueryService;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author maoyz0621 on 2024/5/22
 * @version v1.0
 */
@Component
@AllArgsConstructor
public class DynamicQueryServiceImpl implements IDynamicQueryService {

    private final DynamicQueryMapper dynamicQueryMapper;

    public DynamicQueryMapper getBaseMapper() {
        return dynamicQueryMapper;
    }

    @Override
    public List<Map<String, Object>> select(String tableName, QueryWrapper<?> wrapper) {
        return getBaseMapper().select(tableName, wrapper);
    }

    @Override
    public void selectLargeData(String tableName, QueryWrapper<?> wrapper, ResultHandler<Map<String, Object>> handler) {
        getBaseMapper().selectLargeData(tableName, wrapper, handler);
    }

    @Override
    public int update(String tableName, UpdateWrapper<?> wrapper) {
        return getBaseMapper().update(tableName, wrapper);
    }

    @Override
    public int delete(String tableName, QueryWrapper<?> wrapper) {
        return getBaseMapper().delete(tableName, wrapper);
    }

    @Override
    public int insert(String tableName, String insertField, List<Object> values) {
        return getBaseMapper().insert(tableName, insertField, values);
    }

    @Override
    public int count(String tableName, String key, QueryWrapper<?> wrapper) {
        return getBaseMapper().count(tableName, key, wrapper);
    }
}
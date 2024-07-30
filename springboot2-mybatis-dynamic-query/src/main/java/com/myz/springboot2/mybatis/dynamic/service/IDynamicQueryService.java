/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatis.dynamic.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;

/**
 * @author maoyz0621 on 2024/5/22
 * @version v1.0
 */
public interface IDynamicQueryService {
    /**
     * 执行查询
     *
     * @param tableName 数据库表名称
     * @param wrapper   条件封装器
     * @return Map集合
     */
    List<Map<String, Object>> select(String tableName, QueryWrapper<?> wrapper);

    /**
     * 执行查询
     *
     * @param tableName 数据库表名称
     * @param wrapper   条件封装器
     * @return Map集合
     */
    void selectLargeData(String tableName, QueryWrapper<?> wrapper, ResultHandler<Map<String, Object>> handler);

    /**
     * 执行更新
     *
     * @param tableName 数据库表名称
     * @param wrapper   条件封装器
     * @return 操作影响行数
     */
    int update(String tableName, UpdateWrapper<?> wrapper);

    /**
     * 执行删除
     *
     * @param tableName 数据库表名称
     * @param wrapper   条件封装器
     * @return 操作影响行数
     */
    int delete(String tableName, QueryWrapper<?> wrapper);

    /**
     * 执行添加
     *
     * @param tableName   数据库表名称
     * @param insertField insert字段
     * @param values      insert的值
     * @return 操作影响行数
     */
    int insert(String tableName, String insertField, List<Object> values);

    /**
     * 数量统计
     *
     * @param tableName 数据库表名称
     * @param key       统计字段
     * @param wrapper   条件封装器
     * @return 数量
     */
    int count(String tableName, String key, QueryWrapper<?> wrapper);
}
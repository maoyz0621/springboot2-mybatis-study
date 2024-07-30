/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatis.dynamic.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;

/**
 * @author maoyz0621 on 2024/5/20
 * @version v1.0
 */
@Mapper
public interface DynamicQueryMapper {
    /**
     * 表名
     */
    String TABLE_NAME = "tableName";

    /**
     * 执行查询
     *
     * @param tableName 数据库表名称
     * @param wrapper   条件封装器
     * @return Map集合
     */
    List<Map<String, Object>> select(@Param(TABLE_NAME) String tableName, @Param(Constants.WRAPPER) QueryWrapper<?> wrapper);

    /**
     * 执行查询
     *
     * @param tableName 数据库表名称
     * @param wrapper   条件封装器
     * @return Map集合
     */
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 1000, statementType = StatementType.PREPARED)
    void selectLargeData(@Param(TABLE_NAME) String tableName, @Param(Constants.WRAPPER) QueryWrapper<?> wrapper, ResultHandler<Map<String, Object>> handler);

    /**
     * 执行更新
     *
     * @param tableName 数据库表名称
     * @param wrapper   条件封装器
     * @return 操作影响行数
     */
    int update(@Param(TABLE_NAME) String tableName, @Param(Constants.WRAPPER) UpdateWrapper<?> wrapper);

    /**
     * 执行删除
     *
     * @param tableName 数据库表名称
     * @param wrapper   条件封装器
     * @return 操作影响行数
     */
    int delete(@Param(TABLE_NAME) String tableName, @Param(Constants.WRAPPER) QueryWrapper<?> wrapper);

    /**
     * 执行添加
     *
     * @param tableName   数据库表名称
     * @param insertField insert字段
     * @param values      insert的值
     * @return 操作影响行数
     */
    int insert(@Param(TABLE_NAME) String tableName, @Param("insertField") String insertField, @Param("values") List<Object> values);

    /**
     * 数量统计
     *
     * @param tableName 数据库表名称
     * @param key       统计字段
     * @param wrapper   条件封装器
     * @return 数量
     */
    int count(@Param(TABLE_NAME) String tableName, @Param("key") String key, @Param(Constants.WRAPPER) QueryWrapper<?> wrapper);
}
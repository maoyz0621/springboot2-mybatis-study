/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatis.dynamic.utils;

import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author maoyz0621 on 2024/7/30
 * @version v1.0
 */
public class TableInfoUtils {

    private static final Map<String, TableInfo> TABLE_NAME_INFO_CACHE = new ConcurrentHashMap<>();

    private static volatile boolean inited = false;

    public static TableInfo getTableInfo(Class<?> clazz) {
        return TableInfoHelper.getTableInfo(clazz);
    }

    public static TableInfo getTableInfo(String tableName) {
        if (!inited) {
            init(tableName);
        }
        return TABLE_NAME_INFO_CACHE.get(tableName);
    }

    private synchronized static void init(String tableName) {
        for (TableInfo tableInfo : TableInfoHelper.getTableInfos()) {
            TABLE_NAME_INFO_CACHE.put(tableName, tableInfo);
        }
        inited = true;
    }

    /**
     * 3.5之后提供
     */
    // public static TableInfo getTableInfo(String tableName) {
    //     return TableInfoHelper.getTableInfo(tableName);
    // }

}
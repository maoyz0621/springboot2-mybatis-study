/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatisplus.sqlite.service;

import com.myz.springboot2.mybatisplus.sqlite.entity.SqliteUserPo;

import java.util.List;

/**
 * @author maoyz0621 on 2024/5/20
 * @version v1.0
 */
public interface ISqliteUserService {

    List<SqliteUserPo> selectList();

    boolean save(SqliteUserPo sqliteUserPo);

    SqliteUserPo getById(long id);
}
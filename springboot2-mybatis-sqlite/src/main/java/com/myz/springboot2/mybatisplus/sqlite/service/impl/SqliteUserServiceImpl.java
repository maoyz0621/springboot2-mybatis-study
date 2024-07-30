/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatisplus.sqlite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myz.springboot2.mybatisplus.sqlite.entity.SqliteUserPo;
import com.myz.springboot2.mybatisplus.sqlite.mapper.SqliteUserMapper;
import com.myz.springboot2.mybatisplus.sqlite.service.ISqliteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maoyz0621 on 2024/5/20
 * @version v1.0
 */
@Service
public class SqliteUserServiceImpl extends ServiceImpl<SqliteUserMapper, SqliteUserPo> implements ISqliteUserService {

    @Autowired
    SqliteUserMapper sqliteUserMapper;


    @Override
    public List<SqliteUserPo> selectList() {
        return sqliteUserMapper.selectList(null);
    }
}
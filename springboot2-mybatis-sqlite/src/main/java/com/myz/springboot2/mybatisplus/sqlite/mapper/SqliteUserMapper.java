/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatisplus.sqlite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myz.springboot2.mybatisplus.sqlite.entity.SqliteUserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author maoyz0621 on 2024/5/20
 * @version v1.0
 */
@Mapper
public interface SqliteUserMapper extends BaseMapper<SqliteUserPo> {
}
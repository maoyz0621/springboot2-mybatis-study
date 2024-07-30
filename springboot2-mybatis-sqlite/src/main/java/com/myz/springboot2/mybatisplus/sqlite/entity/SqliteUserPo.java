/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatisplus.sqlite.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author maoyz0621 on 2024/5/20
 * @version v1.0
 */
@Data
@TableName("user")
public class SqliteUserPo {

    @TableId
    private Long id;

    private String username;

    private Integer age;
}
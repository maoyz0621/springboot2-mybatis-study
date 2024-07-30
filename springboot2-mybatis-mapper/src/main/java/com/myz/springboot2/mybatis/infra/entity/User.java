package com.myz.springboot2.mybatis.infra.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/*
 * Created by maoyz on 17-9-12.
 */
@Data
@TableName("t_user")
public class User {

    @TableId
    private Long id;

    private String lastName;


    private String gender;

    private String email;
    //　多对一关系(association)
    private Role role;

    public User() {
    }
}

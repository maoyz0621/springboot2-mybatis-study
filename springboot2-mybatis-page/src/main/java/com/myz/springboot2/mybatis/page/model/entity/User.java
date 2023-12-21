package com.myz.springboot2.mybatis.page.model.entity;

import lombok.Data;

/*
 * Created by maoyz on 17-9-12.
 */
@Data
public class User {

    private Long id;
    private String lastName;
    private String gender;

    private String email;
    //　多对一关系(association)
    private Role role;

    public User() {
    }
}

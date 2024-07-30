package com.myz.springboot2.mybatis.datasource.dynamic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.myz.springboot2.mybatis.datasource.dynamic.constants.DynamicDatasourceConstant;
import com.myz.springboot2.mybatis.infra.entity.User;
import com.myz.springboot2.mybatis.infra.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 指定库：@DS
 *
 * @author maoyz0621
 */
@DS(DynamicDatasourceConstant.MASTER)
@Service
public class MasterService {

    @Resource
    private UserMapper userMapper;

    public void selectAll() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}

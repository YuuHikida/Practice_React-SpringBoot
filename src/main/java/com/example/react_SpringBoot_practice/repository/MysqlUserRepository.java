package com.example.react_SpringBoot_practice.repository;

import com.example.react_SpringBoot_practice.entity.UserEntity;
import com.example.react_SpringBoot_practice.mapper.UserMapper;
import com.example.react_SpringBoot_practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MysqlUserRepository implements UserRepository {

    private final UserMapper userMapper;
    public MysqlUserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserEntity selectAllName(int id) {
        return this.userMapper.selectAllName(id);
    }
}

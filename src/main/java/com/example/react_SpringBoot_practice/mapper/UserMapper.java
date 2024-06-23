package com.example.react_SpringBoot_practice.mapper;


import com.example.react_SpringBoot_practice.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users my_table")
    List<User> findAll();
}
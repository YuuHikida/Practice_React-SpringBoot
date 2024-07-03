package com.example.react_SpringBoot_practice.mapper;

import com.example.react_SpringBoot_practice.entity.UserEntity;
import com.example.react_SpringBoot_practice.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /*
    UserEntity selectAll..の型でUserEntityを指定することで
    勝手にマッピングしてくれ、UserEntity型を返す
     */
    @Select("SELECT * FROM my_table WHERE id = #{id}")
    UserEntity selectAllName(int id);
}

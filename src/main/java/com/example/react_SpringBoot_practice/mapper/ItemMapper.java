package com.example.react_SpringBoot_practice.mapper;

import com.example.react_SpringBoot_practice.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ItemMapper
{
    @Select("SELECT * FROM Item WHERE id = #{id}")
    Item findById(int id);
}

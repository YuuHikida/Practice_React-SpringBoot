package com.example.react_SpringBoot_practice.repository;

import com.example.react_SpringBoot_practice.entity.UserEntity;
import com.example.react_SpringBoot_practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//<"エンティティクラス","主キーのフィールド">

public interface UserRepository {
    UserEntity selectAllName(int id);
}

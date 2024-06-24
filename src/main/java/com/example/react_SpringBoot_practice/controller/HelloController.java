package com.example.react_SpringBoot_practice.controller;

//Model
import com.example.react_SpringBoot_practice.dto.UserResponse;
import com.example.react_SpringBoot_practice.entity.Item;
import com.example.react_SpringBoot_practice.entity.UserEntity;
import com.example.react_SpringBoot_practice.mapper.ItemMapper;
import com.example.react_SpringBoot_practice.model.User;
import com.example.react_SpringBoot_practice.repository.UserRepository;

import com.example.react_SpringBoot_practice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
「@CrossOrigin(origins = "*")」
上記のAPIがフロント側で呼んだ時に、アノテーションがないとエラーが出る
 == CORSを制御している
*/
@RestController
@CrossOrigin(origins = "*")
public class HelloController {

    private final UserService userService;


    public HelloController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/api")
//    @ResponseBody       //HTTPレスポンスのボディとして使用される
//    public BirthStone getBirthStone() {
//        BirthStone birthStone = new BirthStone();
//        birthStone.setMonth("2月");
//        birthStone.setName("アメジスト");
//        birthStone.setColor("紫");
//        //test
//        return birthStone;
//    }
//    @GetMapping("/{id}")
//    public UserResponse findById(@PathVariable int id)
//    {   // DBからidをキーにデータを取得
//        UserEntity userEntity =  userService.getAllName(id);
//        // Responseにデータをコピーしてreturn;
//        UserResponse userResponse = new UserResponse();
//        // 2つのオブジェクト間でプロパティの値をコピーする為に利用する
//        BeanUtils.copyProperties( userEntity, userResponse );
//        return userResponse;
//    }

    @GetMapping("/{id}")
    public UserEntity get(@RequestParam int id)
    {
        return userService.getName(id);
    }

}

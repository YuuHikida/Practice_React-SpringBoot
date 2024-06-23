package com.example.react_SpringBoot_practice.controller;

//Model
import com.example.react_SpringBoot_practice.model.User;
import com.example.react_SpringBoot_practice.repository.UserRepository;

import com.example.react_SpringBoot_practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
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

    @GetMapping("/userInfo")
    public List<User> getAllEntities()
    {
        return userService.getAllName();
    }






}

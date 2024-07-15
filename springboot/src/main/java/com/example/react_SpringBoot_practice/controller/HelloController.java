package com.example.react_SpringBoot_practice.controller;

//Model
import com.example.react_SpringBoot_practice.entity.UserEntity;
import com.example.react_SpringBoot_practice.entity.Item;
import com.example.react_SpringBoot_practice.mapper.ItemMapper;
import com.example.react_SpringBoot_practice.model.User;
import com.example.react_SpringBoot_practice.repository.UserRepository;
import com.example.react_SpringBoot_practice.model.BirthStone;

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
@RequestMapping("/api")//すべてのエンドポイントを定義する
public class HelloController {

    private final UserService userService;


    public HelloController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    @ResponseBody       //HTTPレスポンスのボディとして使用される
    public BirthStone getBirthStone() {
        BirthStone birthStone = new BirthStone();
        birthStone.setMonth("2月");
        birthStone.setName("アメジスト");
        birthStone.setColor("紫");
        //test
        return birthStone;
    }

    //@RequestParamは /api/xxx ? id =123 などを受け取る
    //@PathVariableは /api/123   などの123を受け取る
    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id)
    {
        User user = new User();
        UserEntity userEntity = userService.getName(id);
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        return user;

    }

    //暫定テスト用
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String moji()
    {
        String answer = "KON^^";
        return answer;
    }

}

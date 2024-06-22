package com.example.react_SpringBoot_practice.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//Model
import com.example.react_SpringBoot_practice.model.BirthStone;


/*
「@CrossOrigin(origins = "*")」
上記のAPIがフロント側で呼んだ時に、アノテーションがないとエラーが出る
 == CORSを制御している
*/

@RestController
@CrossOrigin(origins = "*")
public class HelloController {

    @GetMapping("/api")
    @ResponseBody       //HTTPレスポンスのボディとして使用される
    public BirthStone getBirthStone() {
        BirthStone birthStone = new BirthStone();
        birthStone.setMonth("2月");
        birthStone.setName("アメジスト");
        birthStone.setColor("紫");
        //test
        return birthStone;
    }
}

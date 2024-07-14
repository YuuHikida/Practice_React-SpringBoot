package com.example.react_SpringBoot_practice.controller;

import com.example.react_SpringBoot_practice.entity.UserEntity;
import com.example.react_SpringBoot_practice.model.BirthStone;
import com.example.react_SpringBoot_practice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*MEMO*/
/*１	@Test	実際にテストを記述するメソッドに付与する。
２	@BeforeAll	全テストの実行前に１度のみ実行するメソッドに付与する。
３	@AfterAll	全テストの実行後に１度のみ実行するメソッドに付与する。
４	@BeforeEach	各テストの実行前に毎回実行するメソッドに付与する。
５	@AfterEach	各テストの実行後に毎回実行するメソッドに付与する。

assertEquals(a,b)	aとbが等しい（equal）ことをテストする。
2	assertNotEquals(a,b)	aとbが等しくないことをテストする。
3	assertNotNull(a)	aがnullでないことをテストする。
4	assertTrue(a)	aが trueであることをテストする。
5	assertTimeOut(a,b)	bの処理がa以内に終わることをテストする。
6	assertThrows(a,b)	bの処理がa（サブクラスを含む）の例外クラスを投げることをテストする。
 */


//↓HelloControlerクラステストを実行
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;
    /*
    モック化は対象クラスが他のクラスに依存している場合に
    テスト対象が呼び出している他クラスをテスト用のモックに差し替え、動作ない良い用を定義する
     */
    @MockBean
    private UserService userService;
    private UserEntity userEntity;

    //↓テストメソッドの実行前に毎回実行される
    @BeforeEach
    public  void beforeEach()
    {
        userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setName("kon");
//        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController("/api")).build();
    }

    @Test
    public void testMoji() throws Exception
    {
        mockMvc.perform(get("/test"))
                .andExpect(status().isOk());
    }

//    @Test
//    public void testGetUserById() throws Exception {
//        // モックの振る舞いを定義
//        when(userService.getName(1)).thenReturn(userEntity);
//
//        // エンドポイントを呼び出して検証
//        mockMvc.perform(get("/api/1"))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.id").value(1))
//                .andExpect((ResultMatcher) jsonPath("$.name").value("Test User"));
//
//        // モックが期待通りに呼び出されたか確認
//        verify(userService, times(1)).getName(1);
//    }

}
package com.example.react_SpringBoot_practice.controller;

import com.example.react_SpringBoot_practice.entity.UserEntity;
import com.example.react_SpringBoot_practice.model.BirthStone;
import com.example.react_SpringBoot_practice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
public class HelloControllerTest
{

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
    public void beforeEach()
    {
        userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setName("TANAKA TARO");
//        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController("/api")).build();
    }

    @Test
    public void testGetBirthStone() throws Exception {
        // リクエストの送信とレスポンスの検証
        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.month").value("2月"))
                .andExpect(jsonPath("$.name").value("アメジスト"))
                .andExpect(jsonPath("$.color").value("紫"));
    }

    @Test
    public  void testGetUser()throws Exception {
        //モック定義
        when(userService.getName(1)).thenReturn(userEntity);

        // リクエストの送信とレスポンスの検証
        mockMvc.perform(get("/api/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("TANAKA TARO"));
    }

}

    /*  ↓　Mockitoを使ってクラスのインスタンスを使ってテスト(Httpリクエストテストはしていない)

    @InjectMocks
    private HelloController helloController;

    public HelloControllerTest()
    {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testMoji()
    {
        String result = helloController.moji();

        assertEquals("KON^^",result);
    }
     */

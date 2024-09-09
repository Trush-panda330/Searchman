package com.example.demo;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class) // Springのテスト実行をサポートするためのアノテーション
@SpringBootTest // Spring Bootのコンテキストを読み込んでテストするアノテーション
public class ModelTest {

    // MockMvcはSpring MVCを実際に起動せずにコントローラーのテストをするためのオブジェクト
    private MockMvc mockMvc;

    // テスト対象のEmployeeControllerをAutowiredでインジェクション
    @Autowired
    EmployeeController target;

    // テストが実行される前にMockMvcをセットアップするメソッド
    @Before
    public void setup() {
        // standaloneSetupは特定のコントローラーだけを対象とするテスト環境を構築する
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }

    // モックとしてEmployeeServiceを定義
    @MockBean
    private EmployeeService employeeService;

    // モデルにセットされている値をテストするメソッド
    @Test
    public void isModelTest() throws Exception {
        // モックのEmployeeServiceのfindByNoメソッドが呼び出されたら、"佐藤"を返すように設定
        when(employeeService.findByNo("100")).thenReturn("佐藤");

        // POSTリクエストを/outputに対して送信し、number=100を渡す
        mockMvc.perform(post("/output?number=100"))
            // モデルの"name"属性が"佐藤"であることを期待する
            .andExpect(model().attribute("name", "佐藤"));
    }

}

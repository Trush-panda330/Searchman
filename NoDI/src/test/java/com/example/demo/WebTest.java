package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // MockMvcのリクエストビルダーを使用するためのインポート
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // MockMvcの結果マッチャーを使用するためのインポート

import org.junit.Before; // JUnitのテスト前に実行するメソッドを定義するための
import org.junit.Test; // JUnitのテストメソッドを定義するためのインポート
import org.junit.runner.RunWith; // JUnitのランナーを指定するためのインポート
import org.springframework.beans.factory.annotation.Autowired; // Springの依存性注入を行うためのインポート
import org.springframework.boot.test.context.SpringBootTest; // Spring Bootのテスト環境を設定するためのインポート
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; // SpringのJUnitランナーを指定するためのインポート
import org.springframework.test.web.servlet.MockMvc; // MockMvcを使用してMVCリクエストをテストするためのインポート
import org.springframework.test.web.servlet.setup.MockMvcBuilders; // MockMvcのセットアップを行うためのインポート

// SpringJUnit4ClassRunnerでテストを実行することを指定
@RunWith(SpringJUnit4ClassRunner.class)
// Spring Bootのアプリケーションコンテキストを読み込んでテストを実行
@SpringBootTest
public class WebTest {

	private MockMvc mockMvc; // MockMvcのインスタンスを保持するためのフィールド

	// Springによって依存性注入されるコントローラ
	@Autowired
	EmployeeController target;

	// テストメソッドが実行される前に呼び出されるメソッド
	@Before
	public void setup() {
		// MockMvcのセットアップ。コントローラをスタンドアロンでテストするためのビルダーを使用
		mockMvc = MockMvcBuilders.standaloneSetup(target).build();
	}

	// HTTPリクエストをシミュレートし、レスポンスのステータスコードが200 OKであることを確認するテストメソッド
	@Test
	public void isStatusTest() throws Exception {
		// /outputエンドポイントにGETリクエストを送り、ステータスが200 OKであることを確認
		mockMvc.perform(get("/output")).andExpect(status().isOk());
	}
}

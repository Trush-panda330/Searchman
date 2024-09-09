package com.example.demo;

import static org.junit.Assert.*; // アサーション（assertEqualsなど）を使用するためのインポート
import static org.mockito.Mockito.*; // Mockitoのモック機能（whenなど）を使用するためのインポート

import org.junit.Test; // JUnitのテストを記述するためのインポート
import org.junit.runner.RunWith; // テストクラスにランナーを設定するためのインポート
import org.springframework.boot.test.mock.mockito.MockBean; // SpringのMockBeanを使用するためのインポート
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; // SpringJUnit4ClassRunnerを使用するためのインポート

// SpringJUnit4ClassRunnerでテストを実行することを指定
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {

	// EmployeeRepositoryをモックにするためのアノテーション。実際のリポジトリではなく、模擬的なものを使う
	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void findByNoTest() throws Exception {
		// employeeRepositoryのモックを設定。selectByNoが"100"を引数に呼び出されたときに"佐藤"を返すようにする
		when(employeeRepository.selectByNo("100")).thenReturn("佐藤");

		// テスト対象のEmployeeServiceをインスタンス化する
		EmployeeService employeeService = new EmployeeServiceImpl();

		// 実際にfindByNoを呼び出し、結果を取得
		String employee = employeeService.findByNo("100");

		// 期待値"佐藤"と結果が一致しているか確認
		assertEquals(employee, "佐藤");
	}
}

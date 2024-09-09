package com.example.demo;

import org.springframework.stereotype.Service;

@Service //Bean化
public class EmployeeServiceImpl implements EmployeeService {
	
	//employeeRepositoryの宣言と
	private final EmployeeRepository employeeRepository;
	
	//コンストラクタでの代入
	//EmployeeRepositoryのDI
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public String findByNo(String number) {
		//リポジトリから社員を選択
		//依存性の注入をしていないとここでエラーになっている
//		EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
		String name = employeeRepository.selectByNo(number);
		return name;
	}
}

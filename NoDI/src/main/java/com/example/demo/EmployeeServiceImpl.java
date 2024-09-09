package com.example.demo;

public class EmployeeServiceImpl implements EmployeeService {
	@Override
	public String findByNo(String number) {
		//リポジトリから社員を選択
		EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
		String name = employeeRepository.selectByNo(number);
		return name;
	}
}

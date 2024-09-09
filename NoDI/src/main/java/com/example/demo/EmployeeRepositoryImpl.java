package com.example.demo;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	@Override
	public String selectByNo(String number) {
		String name;
		switch (number) {
		case "100":
			name = "佐藤";
			break;

		case "101":
			name = "東";
			break;
			
		case "102": 
			name = "ueda";
			break;
		default :
			name = "登録されていません";
			
		}

		return name;
	}

}

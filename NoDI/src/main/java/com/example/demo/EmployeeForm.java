package com.example.demo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class EmployeeForm {
	@NotEmpty(message="社員Noを入力してください")
	@Pattern(regexp ="^[0-9]{3}$", message="半角数字、3ケタでお願いします")
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}

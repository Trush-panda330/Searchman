package com.example.demo;

import jakarta.validation.constraints.NotEmpty;

public class ShainForm {
	@NotEmpty(message="社員Noを入力してください")
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}

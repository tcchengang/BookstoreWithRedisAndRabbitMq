package com.example.demo.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



public class LoginVo {
	@NotNull
	private String userName;
	
	@NotNull
	private String userPass;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Override
	public String toString() {
		return "LoginVo [userName=" + userName + ", userPass=" + userPass + "]";
	}
	
	
}

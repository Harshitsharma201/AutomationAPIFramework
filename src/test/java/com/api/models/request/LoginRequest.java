package com.api.models.request;

public class LoginRequest {
	
	public LoginRequest(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}

	private String password;
	
	private String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "LoginRequest [password=" + password + ", username=" + username + "]";
	}
	
}

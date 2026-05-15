package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description="Forgot Password test")
	public void forgotPasswordTest() {
		AuthService authService=new AuthService();
		Response response=authService.forgotPassword("testautomationacademy33@gmail.com");
		
		System.out.print(response.asPrettyString());
	}
}

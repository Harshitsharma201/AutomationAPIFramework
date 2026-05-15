package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description="Verify if SignUp API is working")
	
	public void createAccountTest() {
		
		SignUpRequest signUpRequest=new SignUpRequest.Builder()
				.email("riya01@yahoo.com")
				.firstName("riya")
				.lastName("sharma")
				.mobileNumber("7777977796")
				.password("riya125")
				.build();
		
			AuthService authService=new AuthService();
			Response response=authService.signUp(signUpRequest);
			System.out.print(response.asPrettyString());
			Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK but got " + response.getStatusCode());
		    
		    // 4. Assert: Check the specific message in the response body
		    // Using response.asString().contains() is safer than assertEquals for long JSONs
		  
	}
}

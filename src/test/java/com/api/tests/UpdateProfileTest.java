package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description="update user profile test")
	public void updateProfileTest()
	{
		LoginRequest loginRequest=new LoginRequest("uday12345","uday1234");
		AuthService authService=new AuthService();
		Response response=authService.login(loginRequest);
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		System.out.println("--------------------------------------------------------------------------");
		
		UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(),"uday1234");
		System.out.println(response.asPrettyString());
		
		System.out.println("---------------------------------------------------------------------------");
		ProfileRequest profileRequest=new ProfileRequest.Builder()
				.firstName("Disha")
				.lastName("Bhat")
				.email("disha12@gmail.com")
				.mobileNumber("9786521011")
				.build();
		
		response=userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
		
		
	}
}

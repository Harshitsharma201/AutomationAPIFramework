package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginAPITest {
	
	@Test(description="To verify if login API is working ")
	public void loginTest() {
//		RestAssured.baseURI="http://64.227.160.186:8080";
		Response response=RestAssured.given().baseUri("http://64.227.160.186:8080")
		.header("Content-type","application/json")
		.body("{\"username\": \"uday1234\", \"password\": \"uday12345\"}")
		.post("/api/auth/login");
		
		System.out.print("Response of the API is:- "+ response.asPrettyString());
		
		Assert.assertEquals(response.statusCode(), 200);
	}
	
}

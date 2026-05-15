package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.filters.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {//Wrapper for restAssured
	
	//handling the base URI
	//Creating the request
	//handling the response

	private static final String BASE_URL="http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	static {
        RestAssured.filters(new LoggingFilter());
    }
	public BaseService() {
		this.requestSpecification=RestAssured.given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization","Bearer "+token);
	}
	
	protected Response postRequest(Object payload,String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response postRequest(String baseUrl,Object payload,String endpoint) {
		return requestSpecification.baseUri(baseUrl).contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response putRequest(Object payload,String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}

	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
}

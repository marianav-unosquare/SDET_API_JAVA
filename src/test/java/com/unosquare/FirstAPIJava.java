package com.unosquare;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.*;

public class FirstAPIJava {
	@Test
	public void f() {

		RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users/2");

		int statusCode = response.getStatusCode();

		Reporter.log("Sucess 200 validation");
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		response.body("data.first_name", equalTo("Janet"));
		
		Reporter.log(response.body().asString());
	}

}

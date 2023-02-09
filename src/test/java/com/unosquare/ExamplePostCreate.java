package com.unosquare;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import org.hamcrest.*;

public class ExamplePostCreate {
	
	
	public void a() {
	  put("name","JohnAPI");
	  put("job","QA");
	  
		 baseURI = "https://reqres.in/api"; 
		 RequestSpecification httpRequest = given(); 
		 httpRequest.headers("Content-Type", "application/json");
		 httpRequest.body(toString());
		 Response response = httpRequest.post("/users");
	}
}

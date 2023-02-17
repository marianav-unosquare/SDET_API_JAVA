package com.unosqare.pojo;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Constants;

public class CustomRequest {
	private String resource;
	private RequestSpecification httpRequest;
	private Map<String, String> headers = new HashMap<>();
	private Map<String, String> queryParams = new HashMap<>();
	
	//Constructor
	public CustomRequest(String resource) {
		this.resource = resource;
		baseURI= Constants.BASE_URI ;
		httpRequest = given();
	}
	
	@SuppressWarnings("serial")
	public CustomRequest(String resource, String body) {
		this(resource);
		addHeaders(new HashMap<String, String>() {{
			put("Content-Type", "application/json");
		}});
		httpRequest.body(body);
	}
	
	public void addHeaders(Map<String, String> extraHeaders) {
		headers.putAll(extraHeaders);
		httpRequest.headers(headers);
	}
	
	public void addQueryParams(Map<String, String> params) {
		queryParams.putAll(params);
		httpRequest.queryParams(queryParams);
	}
	
	public void addBody(String body) {
		httpRequest.body(body);
	}
	
	public Response post() {
		 return httpRequest
		.when()
		.post(resource);
	}
	
	public Response get() {
		 return httpRequest
		.when()
		.get(resource);
	}
	
	public Response put() {
		 return httpRequest
		.when()
		.put(resource);
	}
}

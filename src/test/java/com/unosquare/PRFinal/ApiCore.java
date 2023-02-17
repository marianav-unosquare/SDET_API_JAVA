package com.unosquare.PRFinal;


import java.util.Map;
import com.unosqare.pojo.CustomRequest;
import com.unosqare.pojo.jsonUtil;
import io.restassured.response.Response;

public class ApiCore {

	private Response response;
	private CustomRequest customRequest;
	
	//Constructor for Get requests
	public ApiCore(String resource, String baseURI) {
		setBaseURI(baseURI);
		customRequest = new CustomRequest(resource);
	}
	
	//Constructor for POST and PUT
	public ApiCore(String resource, String fileName, String baseURI) throws Exception {
		setBaseURI(baseURI);
		String body = jsonUtil.readJsonFile(fileName);
		customRequest = new CustomRequest(resource, body);
	}
	
	public void setBaseURI(String baseURI) {
		baseURI = baseURI;
	}

	public Response post() {
		response = customRequest.post();
		return response;
	}

	public Response get() {
		response = customRequest.get();
		return response;
	}
	
	public Response get(Map<String, String> params) {
		customRequest.addQueryParams(params);
		return get();
	}
	
	public Response put() {
		response = customRequest.put();
		return response;
	}
}

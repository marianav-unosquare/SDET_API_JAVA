package com.unosquare.PRFinal;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.unosqare.pojo.User;
import com.unosqare.pojo.jsonUtil;
import io.restassured.response.Response;
import utils.Constants;
import utils.Endpoints;

public class TestMethods {

	ApiCore apiCore;
	Response testResponse;

	@BeforeTest
	public void setup() throws Exception {
		User u = new User();
		u.setName("Grimes");
		u.setJob("Singer");
		jsonUtil.createJsonFile(u, "user1.json");
		
		/*User2 user2 = new User2();
		user2.setEmail("eve.holt@reqres.in");
		user2.setPassword("pistol");
		jsonUtil.createJsonFile(user2, "user2.json");
		User2 user3 = new User2();
		user2.setEmail("eve.holt@reqres.in");
		jsonUtil.createJsonFile(user3, "user3.json");*/
	}

	//@Test()
	public void validatePostLogin() throws Exception {
		apiCore = new ApiCore(Endpoints.POST_USER, "staff.json", Constants.BASE_URI);
		testResponse = apiCore.post();
		assertEquals(testResponse.statusCode(), 201);
		Reporter.log("PostLogin status code: " + testResponse.statusCode());
		Reporter.log("PostLogin response body: " + testResponse.getBody().asPrettyString());
	}
	
	@Test()
	public void validatePostCreateUser() throws Exception {
		apiCore = new ApiCore(Endpoints.POST_USER, "user1.json", Constants.BASE_URI);
		testResponse = apiCore.post();
		assertEquals(testResponse.statusCode(), 201);
		Reporter.log("PostCreateUsers status code: " + testResponse.statusCode());
		Reporter.log("PostCreateUsers response body: " + testResponse.getBody().asPrettyString());
	}
	
	//@Test()
	public void validateSuccessfullPostRegister() throws Exception {
		apiCore = new ApiCore(Endpoints.POST_REGISTER, "user2.json", Constants.BASE_URI);
		testResponse = apiCore.post();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("PostRegister status code: " + testResponse.statusCode());
		Reporter.log("PostRegister response body: " + testResponse.getBody().asPrettyString());
	}
	
	//@Test()
	public void validateUnsuccessfullPostRegister() throws Exception {
		apiCore = new ApiCore(Endpoints.POST_REGISTER, "user3.json", Constants.BASE_URI);
		testResponse = apiCore.post();
		assertEquals(testResponse.statusCode(), 400);
		Reporter.log("PostRegister status code: " + testResponse.statusCode());
		Reporter.log("PostRegister response body: " + testResponse.getBody().asPrettyString());
	}
	
	//@Test()
	public void validateGetUsers() {
		apiCore = new ApiCore(Endpoints.GET_USER, Constants.BASE_URI);
		testResponse = apiCore.get();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("GetUsers status code: " + testResponse.statusCode());
		Reporter.log("GetUsers response body: " + testResponse.getBody().asPrettyString());
	}
	
	//@Test()
	public void validateGetUnknownUser() {
		apiCore = new ApiCore("/users/unknown", Constants.BASE_URI);
		testResponse = apiCore.get();
		assertEquals(testResponse.statusCode(), 404);
		Reporter.log("GetUnknown status code: " + testResponse.statusCode());
		Reporter.log("GetUnknown response body: " + testResponse.getBody().asPrettyString());
	}
	
	//@Test()
	public void validateGetUnknownList() {
		apiCore = new ApiCore("/unknown", Constants.BASE_URI);
		testResponse = apiCore.get();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("GetUnknownList code: " + testResponse.statusCode());
		Reporter.log("GetUnknownList response body: " + testResponse.getBody().asPrettyString());
	}
	
	//@Test()
	public void validateGetUser() {
		apiCore = new ApiCore(Endpoints.GET_USER, Constants.BASE_URI);
		testResponse = apiCore.get();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("GetUser with id=2 status code: " + testResponse.statusCode());
		Reporter.log("GetUser with id=2 response body: " + testResponse.getBody().asPrettyString());
	}
	
	//@Test()
	public void validatePutUser() throws Exception {
		apiCore = new ApiCore(Endpoints.PUT_UPDATE_USER, "user.json", Constants.BASE_URI);
		testResponse = apiCore.put();
		assertEquals(testResponse.statusCode(), 200);
		Reporter.log("GetUser with id=2 status code: " + testResponse.statusCode());
		Reporter.log("GetUser with id=2 response body: " + testResponse.getBody().asPrettyString());
	}
	
}

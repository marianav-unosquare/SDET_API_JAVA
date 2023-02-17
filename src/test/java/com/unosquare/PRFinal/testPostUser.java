package com.unosquare.PRFinal;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.unosqare.pojo.User;
import com.unosqare.pojo.jsonUtil;
import io.restassured.response.Response;
import utils.Constants;

public class testPostUser {

	ApiCore ApiCore;
	Response testResponse;
	
	@BeforeTest
	public void setup() throws Exception {
		User u = new User();
		u.setName("Grimes");
		u.setJob("Singer");
		jsonUtil.createJsonFile(u, "user.json");
	}
	
	@Test(enabled=true)
	public void validatePostAddUser() throws Exception {
	ApiCore = new ApiCore("/api/users", "user.json", Constants.BASE_URI);
	testResponse = ApiCore.post();
	testResponse.then().log().all();
	assertEquals(testResponse.statusCode(), 200);

	}
}

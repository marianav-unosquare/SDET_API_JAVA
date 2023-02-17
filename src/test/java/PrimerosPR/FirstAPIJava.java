package PrimerosPR;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FirstAPIJava {
	@Test
	public void f() {

		baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/users/2");
		
		
		response.then().assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.and()
		.body("data.id", equalTo(2))
		.body("data.email", equalTo("janet.weaver@reqres.in"))
		.body("data.first_name", equalTo("Janet"))
		.body("data.last_name", equalTo("Weaver"))
		.body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
		.body("support.url", equalTo("https://reqres.in/#support-heading"))
		.body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
		.log().all();

		Reporter.log(response.body().asString());
	}
	
	@Test
	public void g () {
		baseURI= "https://reqres.in/api/";
		RequestSpecification httpReq = given();
		Response res = httpReq.get("/unknown/2");
		res.then().assertThat().statusCode(200).and()
		.body("data.id", equalTo(2))
		.body("data.name", equalTo("fuchsia rose"))
		.body("data.year", equalTo(2001))
		.body("data.color", equalTo("#C74375"))
		.body("data.pantone_value", equalTo("17-2031"))
		.body("support.url", equalTo("https://reqres.in/#support-heading"))
		.body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
		.log().all();
		
		Reporter.log(res.body().asString());
	}

	@Test
	public void fixCode() {
		  
			  given()
			  .when()
			  	.get("https://reqres.in/api/users/2")
			  		.then()
			  		.assertThat().statusCode(200)
			  		.assertThat().contentType(ContentType.JSON)
			  		.assertThat()
			  		.body("data.first_name", equalTo("Janet"));
			  
			  Reporter.log("Sucess 200 validation");
		}

	@Test
	public void post_1() {
	//Snippet on how to implement FileReader and convert it to Json Object
		
		/*
		JSONParser json = new JSONParser();
		  FileReader reader = new FileReader(".\\Json\\Register.json");
		  Object obj = json.parse(reader);
		*/
		
		JSONObject req = new JSONObject();
		req.put("name", "Mariana");
		req.put("Job", "QA");
		System.out.println(req.toJSONString());
		
		baseURI= "https://reqres.in/api/";
		
		given().header("Content-Type","application/json")
		//contentType(ContentType.JSON);
		//accept(ContentType.JSON);
		.body(req.toJSONString()).when()
		.post("/users").then().statusCode(201).log().all();
		
		
	}
	
	
	/*public void apicore() throws Exception {
	JSONParser jsonParser = new JSONParser();
	FileReader reader = new FileReader(".\\Json\\Register.json");
	Object obj = jsonParser.parse(reader);
	JSONObject jsonObj = (JSONObject) obj;

	// Variable to store key, value
	HashMap<String, String> map = new HashMap<String, String>();
	JSONObject ob = new JSONObject();

	// Extract values from JSONArray
	JSONArray array = (JSONArray) jsonObj.get("data");
	for (int i = 0; i < array.size(); i++) {
		JSONObject data = (JSONObject) array.get(i);
		String name = (String) data.get("name");
		String job = (String) data.get("job");

		System.out.println("Array JsonData : " + i);
		System.out.println("name : " + name);
		System.out.println("job : " + job);

		map.put("name", name);
		map.put("job", job);

		// Iterate to separate key and value
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
			// Fill JSON object wit pair and value separately
			ob.put(pairs.getKey(), pairs.getValue());
		}

		baseURI = "https://reqres.in/";
		given().log().all().header("Content-Type", "application/json").body(ob.toJSONString()).when().post("/users")
				.then().toString();

	}
}*/

	
}
	

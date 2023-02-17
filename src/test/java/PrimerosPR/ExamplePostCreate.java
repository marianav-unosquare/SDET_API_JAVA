package PrimerosPR;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hamcrest.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ExamplePostCreate {

	@Test
	public void a() throws IOException, ParseException {

		// 1. Leer el archivo JSON y extraer la información del JSON
		JSONParser jsonParser = new JSONParser();
		// Read a file
		FileReader reader = new FileReader(".\\Json\\Register.json");
		// Create obj that can read file
		Object obj = jsonParser.parse(reader);
		JSONObject jsonObj = (JSONObject) obj;

		
		// if(obj instanceof JSONArray) {
		// Variable to store key, value
		HashMap<String, String> map = new HashMap<String, String>();
		JSONObject ob = new JSONObject();
		
		String email= (String) ob.get("email");
		String ps = (String) ob.get("password");

			RestAssured.baseURI = "https://reqres.in/api";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.headers("Content-Type", "application/json");
			httpRequest.body(ob.toString()).log().all();
			Response response = httpRequest.post("/users");
			response.then().assertThat().statusCode(201).log().all();

			int statusCode = response.getStatusCode();
			String StatusCode = String.valueOf(statusCode);

			Reporter.log(response.body().asString());
			Reporter.log(StatusCode);
			Reporter.log(ob.toString());
			Reporter.log(baseURI);

		}

	}


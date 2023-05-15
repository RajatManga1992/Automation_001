package test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchandDeleteExample {
	
	//******PUT TEST RUN******//
	
	@Test
	public void Put_test() {
		baseURI = "https://reqres.in/api";
		JSONObject request = new JSONObject();
		System.out.println(request);
		request.put("name", "Sakshi");
		request.put("job", "Lead_QA");
		System.out.println(request);
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();

	}
	
	//******PATCH TEST RUN******//
	@Test
	public void Patch_test() {
		baseURI = "https://reqres.in";
		JSONObject request = new JSONObject();
		System.out.println(request);
		request.put("name", "Sakshi");
		request.put("job", "Lead_QA_Analist");
		System.out.println(request);
		given( ).header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("/api/users/2").then().statusCode(200).log().all();

	}
	//******Delete TEST RUN******//
	@Test
	public void Test_Delete() {
		baseURI = "https://reqres.in";
		when().delete("/api/users/2").then().statusCode(204).log().all();
	}
	

}

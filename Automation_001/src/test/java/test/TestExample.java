package test;

import org.hamcrest.core.IsEqual;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestExample {
	@Test
	public void Get_test() {
		 baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().  
			statusCode(200).
			body("data[1].id",equalTo(8)).
			body("data[1].first_name",equalTo("Lindsay"));
		
	}
	@Test
	public void Post_test() {
		 baseURI = "https://reqres.in/api";
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("name", "Rajat");
		 map.put("job", "Test Lead_1 ");
		 System.out.println(map);
			JSONObject request = new JSONObject(map);
			//System.out.println(request);
			//request.put("name", "Sakshi");
			//request.put("job", "QA");
			System.out.println(request);
			given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString())
			.when()
			.post("/users").
			then().
			statusCode(201)
			.log().all();
				
		
	}

}

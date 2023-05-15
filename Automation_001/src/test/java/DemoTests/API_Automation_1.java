package DemoTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class API_Automation_1 {

	@Test
	public void test_01() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeaders());
		int Statuscode = response.getStatusCode();
		
		
		Assert.assertEquals(Statuscode, 200);
	}

	@Test
	public void test_2() {
		given().
		get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200);
	}
	
	public void test_3() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
	}
}

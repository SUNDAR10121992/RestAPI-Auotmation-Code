package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;

public class PathAndQueryparameters {

	@Test
	void testQuryAndPathParameters()
	{
	 given()
	
	.pathParam("myPath","users")//path parameters
	.queryParam("page", 1)//query parameters
	.queryParam("id",5)//query parameters
	
	
	.when()
	.get("https://reqres.in/api/{myPath}")
	
	.then().statusCode(200).log().all();
	}
}

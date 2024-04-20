package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	void test_updateUser(ITestContext context)
	{
		
Faker faker=new Faker()	;
		
		JSONObject data=new JSONObject();
		
		data.put("name",faker.name().fullName());
		
		data.put("gender","Male");
		
		data.put("email",faker.internet().emailAddress());
		
		data.put("status","active");
		
		String bearToken="14c977d224e4b63509ea0124156028be2db98f8d3e612d273b252e4c865a6783";
	
		
	//	int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");

		given()
		.headers("Authorization","Bearer "+bearToken)	
		.contentType("application/json")
		.pathParam("id",id)
		.body(data.toString())
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
		
		
	}
}

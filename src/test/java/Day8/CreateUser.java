package Day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test
	void test_createUser(ITestContext context)
	{
		Faker faker=new Faker()	;
		
		JSONObject data=new JSONObject();
		
		data.put("name",faker.name().fullName());
		
		data.put("gender","Male");
		
		data.put("email",faker.internet().emailAddress());
		
		data.put("status","inactive");
		
		String bearToken="14c977d224e4b63509ea0124156028be2db98f8d3e612d273b252e4c865a6783";
	
		
		int id=given()
		.headers("Authorization","Bearer "+bearToken)	
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
	
		
	
	System.out.println("generated ID is as follow "+id);
	
	   context.getSuite().setAttribute("user_id", id);
	    //context.setAttribute("user_id", id);

	}
}

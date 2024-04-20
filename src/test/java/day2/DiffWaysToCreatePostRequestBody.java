package day2;

import org.apache.http.impl.client.TargetAuthenticationStrategy;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DiffWaysToCreatePostRequestBody {
	int id;
//	different ways to create request body 
//	1. Post request body using hashmap
//	2. post request body creation useing Org.JSON
//	3. Post request using external json file data 
//	4.Post request using external json file data 

	
	//@Test(priority = 1)
	void testPostUsingHashMap() {
//post request body using HashMap
		HashMap data = new HashMap();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");

		String courseArr[] = { "C", "C++" };

		data.put("courses",courseArr);
		
		given()
		.contentType("application/json").body(data)
		
		.when()
		.post(" http://localhost:3000/students")
		
		
		
		
		.then()		
         .statusCode(201)
         .body("nameString",equalTo("Scott"))
         .body("location",equalTo("France"))
         .body("phone",equalTo("123456"))
         .body("courses[0]",equalTo("C"))
         .body("courses[1]",equalTo("C++"))
         .header("Content-Type","application/json; charset=utf-8")	
         .log().all();
                		 	 
	}
	//2.post request body using org.json
//@Test(priority = 1)
	void testPostUsingorgjsonlibrary() {
		//post request body using HashMap
				JSONObject data=new JSONObject();
				
				data.put("name", "Scott");
				data.put("location", "France");
				data.put("phone", "123456");

				String courseArr[] = { "C", "C++" };

				data.put("courses",courseArr);
				
				given()
				//we need to convrt json data to String format
				
				.contentType("application/json").body(data.toString())
				
				.when()
				.post(" http://localhost:3000/students")
				
				
				
				
				.then()		
		         .statusCode(201)
		         .body("name",equalTo("Scott"))
		         .body("location",equalTo("France"))
		         .body("phone",equalTo("123456"))
		         .body("courses[0]",equalTo("C"))
		         .body("courses[1]",equalTo("C++"))
		         .header("Content-Type","application/json; charset=utf-8")	
		         .log().all();
		                		 	 
			}
	
	//3.post request body using POJO class
	//@Test(priority = 1)
	void testPostUsingPOJO()
	{
		
		POJOpostRequest data=new POJOpostRequest();
		
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("123456");
		String courseArr[] = { "C", "C++" };
		data.setCourse(courseArr);
				
				given()
				.contentType("application/json")
				.body(data)
				
				.when()
				.post("http://localhost:3000/students")
				
				.then()		
		         .statusCode(201)
		         
		         .body("name",equalTo("Scott"))
		         .body("location",equalTo("France"))
		         .body("phone",equalTo("123456"))
		         .body("course[0]",equalTo("C"))
		         .body("course[1]",equalTo("C++"))
		         .header("Content-Type","application/json; charset=utf-8")
		         .log().all();
		                		 	 
			}
	//4.Using External Json file 
	@Test(priority = 1)
	void testPostUsingExternalJsonFile() throws FileNotFoundException
	{
		
		File f=new File(".\\body.json");
		
		FileReader fr=new FileReader(f);
		
		JSONTokener jTokener=new JSONTokener(fr);
		
		JSONObject data =new JSONObject(jTokener);
		
				given()
				.contentType("application/json")
				.body(data.toString())
				
				.when()
				.post("http://localhost:3000/students")
				
				.then()		
		         .statusCode(201)
		         
		         .body("name",equalTo("Scott"))
		         .body("location",equalTo("France"))
		         .body("phone",equalTo("123456"))
		         .body("course[0]",equalTo("C"))
		         .body("course[1]",equalTo("C++"))
		         .header("Content-Type","application/json; charset=utf-8")
		         .log().all();
		                		 	 
			}
	
	
	

	@Test(priority = 2)
	void testDelete() {
given()

.when()
    .delete("http://localhost:3000/students/25")
.then()
    .statusCode(200);
	}
}

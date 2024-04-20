package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {
	@Test
	void testJsonResponse() {
		// Approach 1

//	given()
//	.contentType(ContentType.Json)
//    .when()
//	.get("http://localhost:3000/store");
//	
//	.then()
//	.statusCode(200)
//	.header("Content-Type","application/json; charset=utf-8")
//	.body("book[3].title",equalTo("the lord of the rings"));

		Response response =

				given().contentType(ContentType.JSON).when().get("http://localhost:3000/store");

//		Assert.assertEquals(response.getStatusCode(), 200);
//		Assert.assertEquals(response.header("content-Type"), "application/json; charset=utf-8");
//
//		String bookString = response.jsonPath().get("book[3].title").toString();
//
//		Assert.assertEquals(bookString, "the lord of the rings");

		JSONObject jO = new JSONObject(response.asString());// converting response to json object

		for (int i = 0; i < jO.getJSONArray("book").length(); i++) {

			String booktitleString = jO.getJSONArray("book").getJSONObject(i).get("title").toString();

			System.out.println(booktitleString);

		}
		//search for title of book in jason
		
		boolean status = false;
		for (int i = 0; i < jO.getJSONArray("book").length(); i++) {

			Object title1 = jO.getJSONArray("book").getJSONObject(i).get("title").toString();

			if (title1.equals("the lord of the rings")) {
				status = true;
				break;
			}

		}
		Assert.assertEquals(status, true);

		double totalprice = 0;
		// validate total price of books
		for (int i = 0; i < jO.getJSONArray("book").length(); i++) {

			String priceofbook = jO.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalprice = totalprice + Double.parseDouble(priceofbook);
		}
		System.out.println(totalprice);
Assert.assertEquals(totalprice, 525.5);
		
	}
}

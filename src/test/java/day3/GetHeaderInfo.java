package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetHeaderInfo {

//	@Test
	void getHeadersinfo() {
		given()

				.when().get("https://www.google.com/")

				.then().header("Content-type", "text/html; charset=ISO-8859-1").and().header("Content-Encoding", "gzip")
				.and().header("Server", "gws");

	}

	@Test
	void testHeaders() {
		Response response = given()

				.when()

				.get("https://www.google.com/");

		// get single header info

//		String headerVaString = response.getHeader("Content-Type");
//		System.out.println("value of content type header is==   " + headerVaString);

//get all headers info         

		Headers myheader = response.getHeaders();

		for (Header hd : myheader) {
			System.out.println(hd.getName() + "=====" + hd.getValue());
		}

	}
}

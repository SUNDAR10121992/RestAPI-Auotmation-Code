package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertFalse;

import java.util.Iterator;
import java.util.*;
import java.util.Set;

import org.apache.http.protocol.ResponseServer;
import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class cookiesDemo {

	// @Test
//	void testCoockies() {
//		given()
//
//				.when()
//
//				.get("https://www.google.com/")
//
//				.then().cookie("AEC", "Ae3NU9Npfyq794Rno_bDs2VXADR7nMGcHRMLRIJB_i3oKvvizKw4YSSSFXE").log().all();
//
//	}

	@Test
	void getCookieInfo() {

		Response res = given()

				.when()
                
				.get("https://www.google.com/");

		// get single cookie information
		/*
		 * // String coockie_Value = res.getCookie("AEC");
		 * System.out.println("Value of coockie is "+coockie_Value);
		 */

		// get all cookie info

		Map<String, String> coockies_value = res.getCookies();

		// System.out.println(coockies_value.keySet());

		for (String k : coockies_value.keySet()) 
		{

			String coockie_value = res.getCookie(k);
           System.out.println(k + "    " + coockie_value);
		
		}

		String contenttypeString = res.getContentType();
		System.out.println("content type is  " + contenttypeString);
	}
}

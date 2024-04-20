package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;


public class LoggingDemo {

	@Test
	void testLogs() {
		given()
		
		.when()
		.get("https://reqres.in/api/users")
		
		
		.then()
		//.log().body();
		.log().headers();
		
	}
}

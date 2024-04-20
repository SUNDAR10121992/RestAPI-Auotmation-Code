package Day8;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import Day7.FakerDataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class GetUser {

	@Test
	void test_getUser(ITestContext context) {
		//int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");

		String bearerTokenString="14c977d224e4b63509ea0124156028be2db98f8d3e612d273b252e4c865a6783";
		
		given()
		
		.headers("Authorization","Bearer "+bearerTokenString)
		.pathParam("id",id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
}

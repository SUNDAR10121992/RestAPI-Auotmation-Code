package Day8;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class DeleteUser {

	@Test
	void testdelete_user(ITestContext context)
	{
		String brarerTokString="14c977d224e4b63509ea0124156028be2db98f8d3e612d273b252e4c865a6783";
		
		//int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");

		given()
		.headers("Authorization","Bearer "+brarerTokString)
		.pathParam("id",id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(204)
		.log().all();
		
		
	}
}

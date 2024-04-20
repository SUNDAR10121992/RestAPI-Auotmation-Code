package day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.File;

import org.testng.annotations.Test;
public class FileUploadAndDownload {

	@Test
	void Sinle_fileupload() {

		File myfile=new File("C:\\Users\\SundarMarutiKande\\Documents\\work.text");
     
		
		given()
        .multiPart("file",myfile)

	.when();
	post("https://the-internet.herokuapp.com/upload")
	
	.then()
	.statusCode(200)
	.body("fileName", equalTo("work.text"))
	.log().all();
		
		
	}
}

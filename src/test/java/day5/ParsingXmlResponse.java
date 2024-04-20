package day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.List;

import org.apache.http.impl.client.TargetAuthenticationStrategy;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class ParsingXmlResponse{
	@Test
	void testXMLResponse() {
		
//		given()
//		
//		.when()
//		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
//        
//		.then()
//		.header("Content-Type","application/xml; charset=utf-8")
//		.body("TravelerinformationResponse.page",equalTo("1"))
//
//		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"))
//		;
	
		//Approach 2 
		
	Response response=	given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
	
	     Assert.assertEquals(response.statusCode(),200);
	Assert.assertEquals(response.header("Content-Type"),"application/xml; charset=utf-8");
	String pageNoString =	response.xmlPath().get("TravelerinformationResponse.page").toString();
	
	//	System.out.println(pageNoString);
		
		Assert.assertEquals(pageNoString,"1");
		String traverName =	response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
	//	System.out.println(traverName);
		Assert.assertEquals(traverName,"Developer");
	}
@Test
	void testXMLResponseBody() {
	    Response response=	given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
	    XmlPath xmlobj=new XmlPath(response.asString());
	
	    
	    ////total number of traveler from response 
	    
	List <String>  travelers=  xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
	
	//  System.out.println(travelers.size());
	
	    Assert.assertEquals(travelers.size(), 10);
	 
	   //verify travelers name from XMl response 
		List <String>travelersNames=  xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		Boolean statusBoolean=false;
		for(String travelernameString :travelersNames)  
		{
			if(travelernameString.equals("ankishRR"))
			{
				statusBoolean=true;
				break;
			}
		}
			Assert.assertEquals(statusBoolean,true);   
	}
}

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_GET_validateJSON_Response
{
	
	@Test
	void validateJSON ()
	{

	//Specify base URI (uniform resorce identifier)
	RestAssured.baseURI = "http://localhost:3000/";

	//Create Request object
	RequestSpecification httpRequest = RestAssured.given();


	//Create Resposne object and what kind of request you need to send with path parameters
	Response response = httpRequest.request(Method.GET, "/hobbies");


	//print response in console window by converting json format to string format
	String resBody = response.getBody().asString();
	System.out.println("Response body is: " + resBody);
	
	
	//Validate outdoor activity in JSON body
	
	Assert.assertEquals(resBody.contains("cricket"), true);
	
	
	
	
	}
	
}

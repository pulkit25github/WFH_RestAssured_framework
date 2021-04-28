import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GET_UserDetails 
{

	@Test
	void getUserDetails ()
	{
		
	//Specify base URI (uniform resorce identifier)
	RestAssured.baseURI = "http://localhost:3000/";
	
	//Create Request object
	RequestSpecification httpRequest = RestAssured.given();
	
	
	//Create Resposne object and what kind of request you need to send with path parameters
	Response response = httpRequest.request(Method.GET, "/users");
		
	
	//print response in console window by converting json format to string format
	String resBody = response.getBody().asString();
	System.out.println("Response body is: " + resBody);
		
	
	//Status code validation
	int statusCode = response.getStatusCode();
	System.out.println("Status code is: " + statusCode);
	Assert.assertEquals(statusCode, 200);
		
	
	//Status line validation
	String statusLine = response.getStatusLine();
	System.out.println("Status line is: " + statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	
	
	}
		

		
		
		
		
		
		
		
	}



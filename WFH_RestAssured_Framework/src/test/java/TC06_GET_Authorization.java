import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC06_GET_Authorization 
{

	@Test
	void getAuthorization ()
	{

	//Specify base URI (uniform resorce identifier)
	RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

	/************* Code for basic auhenctication **************/
	//Basic Authentication
	
	PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
	basicAuth.setUserName("ToolsQA");
	basicAuth.setPassword("TestPassword");           // user and pwd of pavan automation
	
	// need to pass type of authentication
	RestAssured.authentication = basicAuth;      
	
	/******************************************************/
	 
	 
	//Create Request object
	RequestSpecification httpRequest = RestAssured.given();


	//Create Resposne object and what kind of request you need to send with path parameters
	Response response = httpRequest.request(Method.GET, "/");
	
	
	//print response in console window by converting json format to string format
	String resBody = response.getBody().asString();
	System.out.println("Response body is: " + resBody);
	
	//Status code validation
	int statusCode = response.getStatusCode();
	System.out.println("Status code is: " + statusCode);
	Assert.assertEquals(statusCode, 200);
	
	}
}

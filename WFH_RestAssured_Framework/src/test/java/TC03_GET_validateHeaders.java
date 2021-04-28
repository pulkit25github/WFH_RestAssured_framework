import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_GET_validateHeaders
{
	@Test
	void getHeaderDetails ()
	{
		
		//Specify base URI (uniform resorce identifier)
		RestAssured.baseURI = "http://localhost:3000/";
		
		//Create Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		
		//Create Resposne object and what kind of request you need to send with path parameters
		Response response = httpRequest.request(Method.GET, "/places");
			
		
		//print response in console window by converting json format to string format
		String resBody = response.getBody().asString();
		System.out.println("Response body is: " + resBody);
		
		
		//capture details of Headers from response as per postman
		String contentTyp = response.header("Content-Type");
		System.out.println("Content type is: " + contentTyp);
		Assert.assertEquals(contentTyp, "application/json; charset=utf-8");
		
		String contentLen = response.header("Content-Length");
		System.out.println("Content length is: " + contentLen);
		Assert.assertEquals(contentLen, "244");
		
		String date = response.header("Date");
		System.out.println("Date is: " + date);
		
		if(date.contains("Apr 2021"))
				{
				  Assert.assertTrue(true);	
				}
	
		}
			
	/* ********To Capture all Headers *********	
		
		Headers allHeaders = response.headers();
		
		for (Header header : allHeaders)
		{
			System.out.println(header.getName()+ ":                                     "+ header.getValue());
		
		
		*/
	}


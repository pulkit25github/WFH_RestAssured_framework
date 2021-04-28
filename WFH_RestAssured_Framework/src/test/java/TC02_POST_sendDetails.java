import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_POST_sendDetails 
{
    
	@Test
	void sendUserDetail ()
	{
			
    	//Specify base URI (uniform resorce identifier)
    	RestAssured.baseURI = "http://localhost:3000";
    	
    	//Create Request object
    	RequestSpecification httpRequest = RestAssured.given();
    	  	  	
    	
    	//Creating object of Post request - body parameters
        JSONObject requestParams = new JSONObject();
    	
    	//Send details to users using (Hashmap logic of key and value)
        requestParams.put("firstName", "Pawan");
        requestParams.put("lastName", "kumar");
        requestParams.put("age", 64);
        requestParams.put("id", 1);
    	
    	//Type of request or data
        httpRequest.header("Content-Type", "application/json");
    	
    	//Add json to the body of the request
        httpRequest.body(requestParams.toJSONString());
       
        
       //Create Resposne object and what kind of request you need to send with path parameters
    	Response response = httpRequest.request(Method.POST,"/users");
    	
    	
    	//print response in console window by converting json format to string format
    	String resBody = response.getBody().asString();
    	System.out.println("Response body is: " + resBody);
    	
    	//StatusCode valildation
    	int statusCode = response.getStatusCode();
    	System.out.println("Status code is: " + statusCode);
    	Assert.assertEquals(statusCode, 201);
    	
    	//SuccessCode validation
        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println("Success code is: " + successCode);
    	
	}
	
	
	
	
}

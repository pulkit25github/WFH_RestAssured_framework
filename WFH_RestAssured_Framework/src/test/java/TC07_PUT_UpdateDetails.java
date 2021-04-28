import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC07_PUT_UpdateDetails 
{
    @Test
	void putUpdateDetail()
	{
		
		//Specify base URI (uniform resorce identifier)
	//	RestAssured.baseURI = "http://localhost:3000/places?city=ambala";
		
		//Create Request object
		RequestSpecification httpRequest = RestAssured.given();
		
    	//Creating object of Post request - body parameters
        JSONObject requestParams = new JSONObject();
    	
    	//Send details to users using (Hashmap logic of key and value)
        requestParams.put("firstName" , "Miss Inaaya");
        requestParams.put("lastName" , "Rudra");
        requestParams.put("id", "4");
        requestParams.put("age", "2");
        
        
      //Type of request or data
        httpRequest.header("Content-Type", "application/json");
    	
    	//Add json to the body of the request
        httpRequest.body(requestParams.toJSONString());
        
        //To update the entry using put by giving exact url 
        Response response = httpRequest.put("http://localhost:3000/users/4");
        
      //print response in console window by converting json format to string format
    	String resBody = response.getBody().asString();
    	System.out.println("Response body is: " + resBody);
		
		//Validate JSON after updation
        Assert.assertEquals(resBody.contains("Miss"), true);
		
		
		
		
	}
	
	
	
	
}

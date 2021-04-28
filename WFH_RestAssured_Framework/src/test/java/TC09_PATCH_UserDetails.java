import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC09_PATCH_UserDetails 
{

	@Test
	void patchUserDetails()
	{
		
		RestAssured.baseURI = "http://localhost:3000/users";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject reqParams = new JSONObject();
		reqParams.put("firstName", "Nidhi Pulkit");
		reqParams.put("lastName", "Chauhan");
		reqParams.put("age", "32");
		reqParams.put("id", "2");
		
		//type of request
		httpRequest.header("Content-Type", "application/json");
		
		//Attaching request to body of request
		httpRequest.body(reqParams.toJSONString());
		
		Response response = httpRequest.request(Method.PATCH, "/2");
		
		response = httpRequest.get("http://localhost:3000/users");
		
		String resBody= response.getBody().toString();
		
		
		Assert.assertEquals(resBody.contains("Pulkit"), true);
		
		
		
		
	}
	
	
	
}

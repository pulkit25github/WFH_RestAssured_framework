import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC08_DELETE_UserDetails 
{
	
	
	@Test
	void delUserDetails()         // To delete, first run TC02 to add user details
	{
		
		RestAssured.baseURI= "http://localhost:3000/users";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.DELETE, "/1");	
		
		String resBody = response.getBody().asString();
		
		response = httpRequest.get("http://localhost:3000/users");
		
		Assert.assertEquals(resBody.contains("Pawan"), false);
		
		
	}
	
	

}

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC05_GET_validateJSON_All_Values 
{

	@Test
	void validateJSONAllValues ()
	{

	//Specify base URI (uniform resorce identifier)
	RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

	//Create Request object
	RequestSpecification httpRequest = RestAssured.given();


	//Create Resposne object and what kind of request you need to send with path parameters
	Response response = httpRequest.request(Method.GET, "/Chennai");
	
	
	// Validating all values of JSON
	
	JsonPath jsPath = response.jsonPath();
	
	System.out.println(jsPath.get("City"));
	System.out.println(jsPath.get("Temperature"));
	System.out.println(jsPath.get("Humidity"));
	System.out.println(jsPath.get("WeatherDescription"));
	System.out.println(jsPath.get("WindSpeed"));
	System.out.println(jsPath.get("WindDirectiondegree"));
	
	}	
	
	
}

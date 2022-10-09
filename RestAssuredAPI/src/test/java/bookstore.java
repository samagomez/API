import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class bookstore {
	@Test
	 void getbook()
	 {
	  //Specify base URI
		RestAssured.baseURI="https://demoqa.com/BookStore/v1/Book";	
	//  RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"?ISBN=9781449365035");
	 // Response response=httpRequest.request(Method.GET);
	
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody); 
	  
	  
	  
	 JsonPath js= response.jsonPath();
	 System.out.println(js.get("title"));
	 System.out.println(js.get("isbn"));
	 System.out.println(js.get("subTitle"));
	 System.out.println(js.get("author"));
	 System.out.println(js.get("publisher"));
	 
	// int statusCode=response.getStatusCode();
	  //System.out.println("Status code is: "+statusCode);
	  //Assert.assertEquals(statusCode, 200);
	 // Assert.assertEquals(js.get("title"),"Git Pocket Guide");
	 }

}

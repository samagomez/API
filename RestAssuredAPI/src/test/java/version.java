import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class version {
	@Test
	 void getbook()
	 {
	  //Specify base URI
		RestAssured.baseURI="https://pokeapi.co/api/v2/pokemon";	
	//  RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/ditto");
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);  
	 JsonPath js= response.jsonPath();
	 List <Object> abilities=js.get("abilities.ability.name");
	 int CantRegistros=0;
	 CantRegistros=abilities.size();
	 for(int i=0;i<CantRegistros;i++){
	
	 System.out.println(" "+abilities.get(i));//obteniendo habilidades 
	 }
	 List <Object> stats=js.get("stats.stat.name");
	 List <Object> Valuestats=js.get("stats.base_stat");
	 
	 int Canthabilidades=0;
	 Canthabilidades=stats.size();
	 for(int j=0;j<Canthabilidades;j++){
	
	 System.out.println(" "+stats.get(j)+"--"+Valuestats.get(j));//obteniendo habilidades 
	 }
	// int statusCode=response.getStatusCode();
	  //System.out.println("Status code is: "+statusCode);
	  //Assert.assertEquals(statusCode, 200);
	 // Assert.assertEquals(js.get("title"),"Git Pocket Guide");
	 }
	}
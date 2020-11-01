package apiAuthentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OauthRequest {
	@Test
	public void basicPreemtiveTest() {
		Response resp = RestAssured.given()
		.auth().preemptive().basic("Muzna123", "Muz786afe786$")
		.get("https://api.github.com/user");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.then().log().all());
		
	}
	
	@Test
	public void basicChallengeTest() {
		Response resp = RestAssured.given()
		.auth().basic("Muzna123", "Muz786afe786$")
		.get("https://api.github.com/user");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.then().log().all());
		
	}
	@Test
	//By manually passing the token
     public void oauth2Test() {
    	 Response resp1 = RestAssured.given().auth().oauth2("1d709016226f87b2ec1baefdee5a0108032b81b3")
    	 .post("http://coop.apps.symfonycasts.com/api/1114/chickens-feed");
    	 System.out.println("Code :"+resp1.getStatusCode());
    	 System.out.println("Body :"+resp1.getBody().jsonPath().prettify());
     }
	@Test
	//to generate token programatically
	public void oauth2AccessValidAPI() {
		Response resp2 = RestAssured.given()
		.formParam("client_id","MuznaApp")
		.formParam("client_secret","81ceabc4ece4dfb8b63d8647dacba494")
		.formParam("grant_type","client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println(resp2.getBody().asString());
		
		String token=resp2.jsonPath().get("access_token");
		
		Response resp3 = RestAssured.given()
		.auth().oauth2(token).post("http://coop.apps.symfonycasts.com/api/1114/chickens-feed");
		
		System.out.println(resp3.getStatusCode());
		
		System.out.println(resp3.getBody().asString());
		Assert.assertEquals(resp3.getStatusCode(), 200);
		
	}
	
	@Test
	//Negative Scenario
	public void oauth2AccessInValidAPI() {
		Response resp2 = RestAssured.given()
		.formParam("client_id","MuznaApp")
		.formParam("client_secret","81ceabc4ece4dfb8b63d8647dacba494")
		.formParam("grant_type","client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println(resp2.getBody().asString());
		
		String token=resp2.jsonPath().get("access_token");
		
		Response resp3 = RestAssured.given()
		.auth().oauth2(token).post("http://coop.apps.symfonycasts.com/api/1114/eggs-collect");
		
		System.out.println(resp3.getStatusCode());
		
		System.out.println(resp3.getBody().asString());
		Assert.assertEquals(resp3.getStatusCode(),401);
		
	}
}

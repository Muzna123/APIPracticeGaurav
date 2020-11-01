package apiAuthentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiOauth2Authentication {
	/*@Test
	public void apiOauth2Authentication() {
		Response resp = RestAssured.given().auth().oauth2(getTokenID()).
				.get("URI which is accessed by token");
		resp.then().log().all();
		
	}
	public String getTokenId() {
		Response resp = RestAssured.given().auth().basic("ToolsQA", "TestPassword").when()
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
		String tokenId=resp.jsonPath().get("Fault");
		return tokenId;
	}*/

}

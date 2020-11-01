package apiAuthentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiWithBasicChallenging {
	@Test
	public void apiWithBasicChallenging() {
		Response resp = RestAssured.given().auth().basic("ToolsQA", "TestPassword").when()
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
		resp.then().log().all();
	}

}

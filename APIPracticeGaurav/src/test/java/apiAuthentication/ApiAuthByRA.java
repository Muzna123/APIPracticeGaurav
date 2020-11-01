package apiAuthentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiAuthByRA {
	@Test
	public void apiAuthByRA() {
		Response resp = RestAssured.given().auth().preemptive().basic("ToolsQA", "TestPassword").when()
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
		resp.then().log().all();
	}

}

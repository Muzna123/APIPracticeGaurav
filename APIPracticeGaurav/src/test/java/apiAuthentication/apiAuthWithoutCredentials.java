package apiAuthentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apiAuthWithoutCredentials {
	@Test
	public void apiAuthWithoutCredential() {
		Response resp = RestAssured.get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
		resp.then().log().all();
	}

}

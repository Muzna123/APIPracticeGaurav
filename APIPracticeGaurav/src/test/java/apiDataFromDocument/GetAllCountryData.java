package apiDataFromDocument;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllCountryData {
	@Test
	public void fetchCountryDetails() {
		Response resp = RestAssured.get("http://restcountries.eu/rest/v2/all");
		//System.out.println(resp.asString());
		ValidatableResponse vr = resp.then();
		vr.log().all();
	}
}

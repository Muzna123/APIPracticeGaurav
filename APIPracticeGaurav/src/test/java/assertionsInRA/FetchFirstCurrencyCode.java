package assertionsInRA;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchFirstCurrencyCode {
@Test	
public void checkFirstCode() {
		Response resp=RestAssured.get("http://restcountries.eu/rest/v2/all");
		Object code0=resp.jsonPath().get("currencies.code[0]");
		System.out.println("First code"+ code0);
		Object code1=resp.jsonPath().get("currencies.code[1]");
		System.out.println("First code"+ code1);
		Object code249=resp.jsonPath().get("currencies.code[249]");
		System.out.println("First code"+ code249);
	}

}

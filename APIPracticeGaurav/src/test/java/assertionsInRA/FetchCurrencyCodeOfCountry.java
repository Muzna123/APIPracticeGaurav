package assertionsInRA;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchCurrencyCodeOfCountry {
	@Test
	public void FetchCode() {
	Response resp=RestAssured.get("http://restcountries.eu/rest/v2/all");
	Object obj1=resp.jsonPath().get("currencies.code");
	System.out.println(obj1);
	//to get count of currency code
	ArrayList obj=resp.jsonPath().get("currencies.code");
	int count=0;
	for(Object s:obj)
		count++;
		System.out.println("Total codes are:"+ count );	
	}
	

}

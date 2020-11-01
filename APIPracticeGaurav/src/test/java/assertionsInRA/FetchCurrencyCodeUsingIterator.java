package assertionsInRA;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchCurrencyCodeUsingIterator {
	@Test
	public void FetchCodeUsingIterator() {
	Response resp=RestAssured.get("http://restcountries.eu/rest/v2/all");
	Object obj1=resp.jsonPath().get("currencies.code");
	System.out.println(obj1);
	//to get count of currency code
	ArrayList obj=resp.jsonPath().get("currencies.code");
	Iterator I=obj.iterator();
	int count=0;
	while(I.hasNext())
	{
		System.out.println(I.next());
		count++;
	}
	System.out.println("Total codes are:"+ count );
	System.out.println("Total codes are:"+ obj.size());
}
}

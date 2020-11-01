package assertionsInRA;

import java.util.ArrayList;
import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchNoOfBelongingToCountry {
	/*@Test
	public void fetchNoOfBordersBelongingToCountry() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Country name:");
		String countryName=scan.next();
		Response resp = RestAssured.get("http://restcountries.eu/rest/v2/all");
		Object Borders=searchBorders(countryName,resp);
		System.out.println("The borders are for country"+countryName+"are"+Borders);
	}

	public Object searchBorders(String countryName,Response resp) {
		ArrayList<String> obj=resp.jsonPath().get("name");
		Object Borders=null;
		int count=0;
		for(String str:obj) {
			if(str.equals(countryName)) {
			 Borders = resp.jsonPath().get("borders["+count"]");
			}
			count++;
		}
		if(Borders==null) {
			throw new RuntimeException("Invalid Country Name!!!");
		}
		return  Borders;
	}*/
}

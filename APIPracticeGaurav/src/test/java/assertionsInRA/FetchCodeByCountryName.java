package assertionsInRA;

import java.util.ArrayList;
import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchCodeByCountryName {
@Test
public void fetchCodeByCountryName() {
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter the Country Code:");
	String countryName=scan.next();
	Response resp=RestAssured.get("http://restcountries.eu/rest/v2/all");
	ArrayList<String> obj=resp.jsonPath().get("name");
	Object reqCode=fetchCountryCodeByName(obj,countryName,resp);
	System.out.println("Currency code for"+countryName+"is"+reqCode);
}
public Object fetchCountryCodeByName(ArrayList<String> obj,String countryName,Response resp) {
	Object reqCode=null;
	int count=0;
	for(String str:obj) {
		if(str.equals(countryName)) {
			reqCode=resp.jsonPath().get("currencies.code["+count+"]");
			}
		count++;
		}
	if(reqCode==null) {
		throw new RuntimeException("Invalid Country Name!!!");
	}
	return  reqCode;
}

}

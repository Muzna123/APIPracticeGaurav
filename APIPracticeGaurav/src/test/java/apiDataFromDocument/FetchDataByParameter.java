package apiDataFromDocument;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchDataByParameter {
	@Test
	public void fetchDataByParameter() {
		Response resp = RestAssured.get("https://jsonplaceholder.typicode.com/posts?userId=5&id=45");
		resp.then().log().all();
	}

}

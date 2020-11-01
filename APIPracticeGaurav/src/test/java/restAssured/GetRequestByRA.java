package restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestByRA {
	@Test
	public void checkGet() {
		Response resp = RestAssured.get("http://localhost:3000/posts");
		int statusCode = resp.getStatusCode();
		System.out.println("Status code is:" + statusCode);
		System.out.println("-----------------------");
		String contentType = resp.getContentType();
		System.out.println("Content Type is:" + contentType);
		System.out.println("-----------------------");
		String actualResponse = resp.asString();
		System.out.println("Response  is:" + actualResponse);

	}

}

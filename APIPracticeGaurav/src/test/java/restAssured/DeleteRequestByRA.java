package restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequestByRA {
	@Test
	public void checkDelete() {
		Response resp=RestAssured.delete("http://localhost:3000/posts/1");
		int statusCode=resp.getStatusCode();
		System.out.println("Status code is:"+statusCode);
		System.out.println("---------------------");
		String contentType=resp.getContentType();
		System.out.println("ContentType is:"+contentType);
		System.out.println("---------------------");
		String actualResponse=resp.asString();
		System.out.println("Response is:"+actualResponse);
	}

}

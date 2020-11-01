package assertionsInRA;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HeaderAssertionsByTestng {
	@Test
	public void headerAssertionByTestng() {
		Response resp = given().param("userId", 3).pathParam("x", "posts").when()
				.get("https://jsonplaceholder.typicode.com/{x}");
		int statuscode = resp.getStatusCode();
		System.out.println("Status code "+statuscode) ;
		Assert.assertEquals(statuscode, 200);
		String contentType = resp.contentType();
		System.out.println("Content type "+contentType) ;
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		long resptimeInMS = resp.time();
		System.out.println("resptimeInMS "+ resptimeInMS);
		Assert.assertTrue(resptimeInMS<3000);
		long resptimeinSec = resp.timeIn(TimeUnit.SECONDS);
		System.out.println("resptimeSec "+ resptimeinSec);
		Assert.assertTrue(resptimeinSec<3);
		resp.then().log().all();
	}
}

package assertionsInRA;
import static io.restassured.RestAssured.*;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class HeaderAssertionsByRA {
	@Test
	public void CheckRAAssertions() {
		Response resp = given().param("userId", 3).pathParam("x", "posts").when()
				.get("https://jsonplaceholder.typicode.com/{x}");
		ValidatableResponse a=resp.then().assertThat();
		a.statusCode(200);
		a.contentType(ContentType.JSON);
		a.time(Matchers.lessThan(2000l));
		resp.then().log().all();
	}

}

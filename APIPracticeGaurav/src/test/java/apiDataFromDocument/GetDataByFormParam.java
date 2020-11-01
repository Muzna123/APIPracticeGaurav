package apiDataFromDocument;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetDataByFormParam {
	@Test
	public void fetchDataByFormParam() {
		given().formParam("userId", 5).when().get("https://jsonplaceholder.typicode.com/posts").then().log().all();

	}
}

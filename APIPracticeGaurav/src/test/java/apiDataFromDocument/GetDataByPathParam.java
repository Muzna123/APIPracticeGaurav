package apiDataFromDocument;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class GetDataByPathParam {
@Test
public void fetchDataByPathParam() {
	given()
	.param("userId", 3)
	.pathParam("x", "posts")
	.when()
	.get("https://jsonplaceholder.typicode.com/{x}")
	.then().log().all();
}

}

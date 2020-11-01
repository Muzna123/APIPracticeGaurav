package apiDataFromDocument;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class GetDataByParamParam {
	@Test
	public void fetchDataByParamParam() {
		given()
		.param("userId", 4)
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then().log().all();
		
	}

}

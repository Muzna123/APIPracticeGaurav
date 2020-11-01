package apiDataFromDocument;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDataByqueryParam {
	@Test
	public void FetchDataByQueryParam() {
		RequestSpecification req=given();
		RequestSpecification req_with_queryParam=req.queryParam("userId", 5);
		RequestSpecification sender=req_with_queryParam.when();
		Response resp=sender.get("https://jsonplaceholder.typicode.com/posts");
		resp.then().log().all();
	}

}

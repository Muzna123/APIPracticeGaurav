package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequestByRA {
	@Test
	public void patchCheck() {
		RequestSpecification req=RestAssured.given();
		JSONObject jObj=new JSONObject();
		jObj.put("title","TestEngineer");
		jObj.put("author","Neeraja");
		String jsondata=JSONObject.toJSONString(jObj);
		req.contentType(ContentType.JSON);
		req.body(jsondata);
		RequestSpecification sender=req.when();
		Response resp=sender.patch("http://localhost:3000/posts/1");
		int statusCode=resp.getStatusCode();
		System.out.println("Status code is:"+statusCode);
		System.out.println("------------------------");
		String contentType=resp.getContentType();
		System.out.println("ContentType is:"+contentType);
		System.out.println("---------------------");
		String actualResponse=resp.asString();
		System.out.println("Response is:"+actualResponse);
	}

}

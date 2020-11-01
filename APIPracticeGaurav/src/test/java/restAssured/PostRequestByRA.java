package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestByRA {
@Test
public void checkPost()
{
	RequestSpecification req=RestAssured.given();
	JSONObject jObj=new JSONObject();
	jObj.put("id", 15);
	jObj.put("title", "Authorized TE");
	jObj.put("author", "raju");
	String jsondata=JSONObject.toJSONString(jObj);
	req.contentType(ContentType.JSON);
	req.body(jsondata);
	RequestSpecification sender=req.when();
	Response resp=sender.post("http://localhost:3000/posts");
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

package assertionsInRA;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostBulkData {
@Test	
public void bulkData() {
	RequestSpecification req=given();
	JSONObject jobj1=new JSONObject();
	jobj1.put("Java", 10);
	jobj1.put("Selenium", 100);
	jobj1.put("API", 500);
	JSONObject jobj2=new JSONObject();
	jobj2.put("RollNum", 12);
	jobj2.put("Name", "Sudhanshu");
	jobj2.put("Marks", jobj1);
	JSONObject jobj3=new JSONObject();
	jobj3.put("Student", jobj2);
	String JsonData=JSONObject.toJSONString(jobj3);
	req.body(JsonData);
	req.contentType(ContentType.JSON);
	Response resp=req.when().post("http://localhost:3000/posts");
	resp.then().log().all();
		}
}

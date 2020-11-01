package assertionsInRA;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FetchExactDataByJsonPath {
@Test	
public void checkJsonPath() {
	Response resp=get("http://localhost:3000/posts");
    Object SeleniumMarks = resp.jsonPath().get("Student.Marks.Selenium");
	Object APIMarks=resp.jsonPath().get("Student.Marks.API");
	Object Name=resp.jsonPath().get("Student.Name");
	System.out.println(SeleniumMarks);
	
	System.out.println(APIMarks);
	System.out.println(Name);
}

}

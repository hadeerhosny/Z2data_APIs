package getRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetData {
	
	@Test
	public void testResponsecode()
	{
		Response resp=RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available&status=pending&status=sold");
		
		int code=resp.getStatusCode();
		
		System.out.println("Status code is" +code);
		
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void test_Post()
	{
//		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("id", "0");
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			body(request.toJSONString()).
		when().
			post("https://petstore.swagger.io/v2/user").
		then().
			statusCode(200);  
	}


}

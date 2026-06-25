package utils;

import io.qameta.allure.Attachment;
import io.restassured.response.Response;

public class AllureAttachments {
	
	@Attachment(value = "Request Body", 
			type = "application/json")
	public static String attachRequest(String requestBody) {
		return requestBody;
	}
	
	@Attachment(value = "Response Body", 
			type = "application/json")
	public static String attachResponse(Response response) {
		return response.asPrettyString();
	}	

}

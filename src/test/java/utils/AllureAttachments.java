package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.qameta.allure.Attachment;
import io.restassured.response.Response;

public class AllureAttachments {
	
	private static final ObjectMapper MAPPER =
	        new ObjectMapper();
	
	@Attachment(value = "Request Body", 
			type = "application/json")
	public static String attachRequest(String requestBody) {
		return requestBody;
	}
	
	@Attachment(value = "Request Body", 
			type = "application/json")
	public static String attachResponse(Response response) {
		return response.asPrettyString();
	}	

	public static String toJson(Object object) {

	    try {
	        return MAPPER.writerWithDefaultPrettyPrinter()
	                .writeValueAsString(object);

	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}

package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiBaseTest {
	
	@BeforeAll
	static void setup() {
		RestAssured.baseURI = System.getProperty("base.url");;
	}

}

package tests.auth;

import base.BaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import pages.DigestAuthPage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("authenticate and security")
@Story("digest authenticate")
@Tag("smoke")
@Tag("regression")
public class DigestAuthTest extends BaseTest {

	@Test
	void digestAuth_LoginSuccessfully() {
		DigestAuthPage page = new DigestAuthPage();
		
		page.openWithAuth("admin", "admin");
		String message = page.getSuccessMsg();
		
		assertTrue(
				message.contains("Congratulations!"),
				"Digest Auth login failed , actual message is" + message
		);			
	}
}

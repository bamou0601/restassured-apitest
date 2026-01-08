package tests.smoke;

import base.BaseTest;
import io.qameta.allure.*;
import pages.HomePage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("basic interaction")
@Story("web site can be opened nomally")
@Tag("smoke")
public class SmokeTest extends BaseTest {
	
	@Test	
	void open_showHomeMessage() {
		HomePage page = new HomePage();
		page.open();
		assertTrue(page.openSuccess());
	}
}

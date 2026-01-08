package tests.challlengingdom;

import base.BaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import pages.ChallengingDomPage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("abnomal route test")
@Story("unpredicted Dom")
@Tag("smoke")
@Tag("regression")
public class ChallengingDomTest extends BaseTest {
	
	@Test
	void pageShouldHaveThreeButtons() {
		ChallengingDomPage page = new ChallengingDomPage();
		page.open();
		
		assertEquals(3, page.buttonCount(), 
				"button's count should be 3");
	}
	
	@Test
	void tableShouldHaveRows() {
		ChallengingDomPage page = new ChallengingDomPage();
		page.open();
		
		assertTrue(page.rowCount() > 0, 
				"form should have at least 1 row's data");
	}
	
	@Test
	void headerShouldBeStable() {
		ChallengingDomPage page = new ChallengingDomPage();
		page.open();
		
		assertTrue(
				page.getHeaderTexts().contains("Lorem"),
				"header should contain Lorem");	
	}
	
	@Test
	void clickEditeShouldNotThrowError() {
		ChallengingDomPage page = new ChallengingDomPage();
		page.open();
		assertDoesNotThrow(() -> page.clickEdit(0));
	}

}

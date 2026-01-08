package tests.disappearing;

import base.BaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import pages.DisappearingElementsPage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("random and unconfirmation")
@Story("radom element judge")
@Tag("regression")
@Tag("smoke")
public class DisappearingElementsTest extends BaseTest {
	
	@Test
	void requiredMenus_shouldAlwaysExist() {
		DisappearingElementsPage page = new DisappearingElementsPage();
		page.openPage();
		
		assertTrue(page.hasMenu("Home"));
		assertTrue(page.hasMenu("About"));
		assertTrue(page.hasMenu("Contact Us"));
		assertTrue(page.hasMenu("Portfolio"));
	}

	@Test
	void galleryMenu_isOptional() {
		DisappearingElementsPage page = new DisappearingElementsPage();
		page.openPage();
		
		boolean hasGallery = page.hasMenu("Gallery");
		
		//核心点：无论存在与否，用例都不会失败
		System.out.println("Gallery menu present: " + hasGallery);
		assertDoesNotThrow(() -> page.hasMenu("Gallery"));	
	}
	
	@Test
	void galleryShould_appearSometimes() {
		DisappearingElementsPage page = new DisappearingElementsPage();
		boolean appeared = false;
		
		for(int i = 0; i < 5; i++) {
			page.openPage();
			if(page.hasMenu("Gallery")) {
				appeared = true;
				break;
			}						
		}	
		assertTrue(appeared, "Gallery 在多次刷新中至少出现一次");
	}	
}

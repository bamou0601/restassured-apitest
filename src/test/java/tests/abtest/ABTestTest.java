package tests.abtest;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import pages.ABTestPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web UI Automation")
@Feature("subsidized comprehension")
@Story("context fresh and change check")
@Tag("smoke")
public class ABTestTest extends BaseTest {
	
	@Test
	void abTestPageShowValidTitle() {
		ABTestPage page = new ABTestPage();
		page.open();
		//Step 2: checkup for page title's exist
		assertTrue(page.isTitleDisplayed(),
				   "A/B Test title didn't display"
		);
		
		// Step 3: A/B Test core assert
        assertTrue(
                page.hasValidABTestTitle(),
                "A/B Test title didn't accord with expectation，"
                + "actually it's: " +page.getTitleText()
        );
	}
	

}

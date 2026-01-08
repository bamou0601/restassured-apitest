package tests.checkbox;

import base.BaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import pages.CheckboxesPage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("basic interaction")
@Story("chebox's state check")
@Tag("smoke")
@Tag("regression")
public class CheckBoxesTest extends BaseTest {
	
	@Test
	void checkboxInitilState_Should_beCorrect() {
		CheckboxesPage page = new CheckboxesPage();
		page.open();
		
		assertEquals(2, page.checkboxCount(), 
				"check boxes's count is uncorrect");
		
		assertFalse(page.isChecked(0), 
				"Checkbox 1 initial state should be unselected");
		assertTrue(page.isChecked(1),
				"Checkbox 2 initial state should be selected ");	
	}
	
	@Test
	void shouldBeAbleto_ToggleCheckboxes() {
		CheckboxesPage page = new CheckboxesPage();
		page.open();
		
		page.check(0);
		page.uncheck(1);
		
		assertTrue(page.isChecked(0), 
				"Checkbox 1 should be selected");
		
        assertFalse(page.isChecked(1), 
        		"Checkbox 2 shoud be cancelle being selected");
	}
}

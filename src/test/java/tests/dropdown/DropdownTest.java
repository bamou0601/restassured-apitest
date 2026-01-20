package tests.dropdown;

import base.BaseTest;
import io.qameta.allure.*;
import pages.dropdown.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("basic interaction")
@Story("dropdown box operation")
@Tag("smoke")
public class DropdownTest extends BaseTest {
	
	@Test
	void shouldSelectOption1() {
		DropdownPage page = new DropdownPage();
		
		page.openPage();
		page.selectByVisibleText(DropdownOption.OPTION_1);
		
		assertEquals(
				DropdownOption.OPTION_1,
				page.selectedOption()
		);	
	}
	
	@Test
	void shouldSelectOption2() {
		DropdownPage page = new DropdownPage();
		
		page.openPage();
		page.selectByVisibleText(DropdownOption.OPTION_2);
		
		assertEquals(
				"Option 2",
				page.selectedOptionText()
		);	
	}
	
	
	
	
	
	
	
	
	
	
}

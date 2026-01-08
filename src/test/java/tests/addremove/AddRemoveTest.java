package tests.addremove;

import pages.AddRemovePage;
import base.BaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("basic interaction")
@Story("add and remove elements")
@Tag("regression")
public class AddRemoveTest extends BaseTest {
	
	@Test
	void addAndRemoveSuccessfully() {
		AddRemovePage page = new AddRemovePage();
		
		page.open();
		assertFalse(page.hasDeleteButton(), 
				"shoudn't has delete button");
		
		page.addElement();
		assertTrue(page.hasDeleteButton(), 
				"after clicking addBtn, delete element appreared");
		
		page.deleteFirstBtn();
		assertFalse(page.hasDeleteButton(), 
				"after clicking deleteBtn, delete element vanished");
	}
}

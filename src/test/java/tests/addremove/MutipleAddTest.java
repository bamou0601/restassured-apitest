package tests.addremove;

import base.BaseTest;
import io.qameta.allure.*;
import pages.AddRemovePage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("basic interaction")
@Story("add and remove mutil elements")
@Tag("regression")
public class MutipleAddTest extends BaseTest {
	
	@Test
	void shouldAddMultipleElements() {
		AddRemovePage page = new AddRemovePage();
	    page.open();

	    for (int i = 0; i < 3; i++) {
	        page.addElement();
	    }

	    assertEquals(3, page.deleteButtonCount());
	}


}

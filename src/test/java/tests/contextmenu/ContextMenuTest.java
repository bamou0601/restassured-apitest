package tests.contextmenu;

import base.BaseTest;
import io.qameta.allure.*;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import pages.ContextMenuPage;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("complicated user operation")
@Story("rightclick menu")
@Tag("smoke")
@Tag("regression")
public class ContextMenuTest extends BaseTest {
	
	@Test
	void rightClick_TriggerAlert() {
		ContextMenuPage page = new ContextMenuPage();
		page.debugStep();
		page.openPage();
		page.rightClickOnBox();
		
		String alertText = page.getAnd_VerifyAlertText("You selected a context menu");
		
		assertEquals("You selected a context menu", alertText);
		
		page.acceptAlert();		
	}

}

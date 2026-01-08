package tests.dragdrop;

import base.BaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import pages.DragAndDropPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Web UI Automation")
@Feature("complicated user operation")
@Story("drag and drop operation")
@Tag("smoke")
public class DragAndDropTest extends BaseTest {
	
	@Test
	void dragAndDropSuccessTest() {
		DragAndDropPage page =  new DragAndDropPage();
		
		page.open();
		page.dragAToB();
		
		assertTrue(page.isSwapped(), "Box A and B should be swapped");
	}

}

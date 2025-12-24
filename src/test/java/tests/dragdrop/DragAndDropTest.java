package tests.dragdrop;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import pages.DragAndDropPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


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

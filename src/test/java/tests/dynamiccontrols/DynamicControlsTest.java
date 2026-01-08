package tests.dynamiccontrols;

import base.BaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DynamicControlsPage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("elements' state and unstable UI")
@Story("asychorized enable and remove")
@Tag("smoke")
@Tag("regression")
public class DynamicControlsTest extends BaseTest {

    @Test
    void checkbox_can_be_removed_and_added_back() {

        DynamicControlsPage page = new DynamicControlsPage();
        page.openPage();

        // Remove checkbox
        page.clickCheckboxButton();
        page.waitCheckboxDisappear();

        assertFalse(page.isCheckboxPresent(), "checkbox 应该被移除");
        assertEquals("It's gone!", page.getMessage());

        // Add checkbox back
        page.clickCheckboxButton();
        page.waitCheckboxAppear();

        assertTrue(page.isCheckboxPresent(), "checkbox 应该重新出现");
        assertEquals("It's back!", page.getMessage());
    }

    @Test
    void input_can_be_enabled() {

        DynamicControlsPage page = new DynamicControlsPage();
        page.openPage();

        page.clickInputButton();
        page.waitInputEnabled();

        assertTrue(page.isInputEnabled(), "input 应该变为可用");
        assertEquals("It's enabled!", page.getMessage());
    }
}


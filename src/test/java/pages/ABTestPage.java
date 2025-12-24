package pages;

import base.BasePage;
import org.openqa.selenium.By;

import java.util.Set;

public class ABTestPage extends BasePage {
	
	/* =============== Locators =============== */
	private static final String PATH = "/abtest";
	private By title = By.tagName("h3");
    
	/* =============== URL =============== */
	@Override
    protected String path() {
    	return PATH;
    }
	
	/* ============ Page Semantics =========== */
	/*whether page title displayed*/
    public boolean isTitleDisplayed() {
    	return exists(title);
    }
    
    /** get title's text */
    public String getTitleText() {
    	return text(title);
    }

    /** 是否为合法的 A/B Test 标题 */
    /** whether title for A/B Test legal*/
    public boolean hasValidABTestTitle() {
        Set<String> expectedTitles = Set.of(
                "A/B Test Control",
                "A/B Test Variation 1"
        );
        return expectedTitles.contains(getTitleText());
    }
}

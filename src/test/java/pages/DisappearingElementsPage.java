package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.List;


public class DisappearingElementsPage extends BasePage {
	
	private static final String PATH = "/disappearing_elements";
	private final By menuItems = By.cssSelector("ul li a");
	
	@Override
	protected String path() {
		return PATH;
	}
	
	@Step("打开 disappearing elements页面")
	public void openPage() {
		open();
	}
	
	@Step("获取当前菜单文本列表")
	public List<String> getMenuTexts() {
		return findAll(menuItems)
				.stream()
				.map(WebElement::getText)
				.toList();
	}
	
	@Step("判断菜单项是否存在： {menuName}")
	public boolean hasMenu(String menuName) {
		return getMenuTexts().contains(menuName);
	}
	
}

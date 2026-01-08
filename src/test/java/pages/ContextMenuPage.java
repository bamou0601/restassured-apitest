package pages;

import base.BasePage;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContextMenuPage extends BasePage {
	
	private static final String PATH = "/context_menu";
	private final By box = By.id("hot-spot");
	
	@Override
	protected String path() {
		return PATH;
	}
	
	/*==============page actions==============*/
	@Step("打开Context Menu页面")
	public void openPage() {
		open();
	}
	
	@Step("DEBUG Step Test")
	public void debugStep() {
	    System.out.println("step executed");
	}
	
	@Step("在灰色区域执行右键点击")
	public void rightClickOnBox() {
		Actions actions = new Actions(driver());
		actions.contextClick(visible(box)).perform();
	}
	
	@Step("获取弹窗文本")
	public String getAlertText() {
		return getWait()
			.until(ExpectedConditions.alertIsPresent())
			.getText();
	}
	
	@Step("右键并获取弹窗文本")
	public String rightClick_And_GetAlertText() {
		rightClickOnBox();
		return getAlertText();
	}
	
	@Step("弹窗文本应为： {expected}")
	public String getAnd_VerifyAlertText(String expected) {
		return getWait()
				.until(ExpectedConditions.alertIsPresent())
				.getText(); 
	}
	
	@Step("关闭弹窗")
	public void acceptAlert() {
		driver().switchTo().alert().accept();
	}
		
}

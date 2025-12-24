package utils;

import base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 *  语义化
 *  Page 不碰 Selenium API
 *  稳定性高
 */

public class WaitUtils {

    public static void waitVisible(By locator, long seconds) {
        new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(seconds)
        ).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void clickWhenReady(By locator, long seconds) {
        new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(seconds)
        ).until(ExpectedConditions.elementToBeClickable(locator))
         .click();
    }
}

package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
/*
 * 每个test方法一个driver
 * 并行完全安全
 * 职责：WebDriver初始化/回收
 * 测试级别通用能力（截图、日志以后加）
 * 不允许出现页面细节
 */
public abstract class BaseTest {
	
	@BeforeEach
	void setup() {
		DriverManager.setDriver(DriverFactory.createDriver());	
	}
	
	@AfterEach
	void tearDown() {
		DriverManager.quitDriver();
	}	
}

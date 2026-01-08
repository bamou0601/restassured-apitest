package tests.login;

import base.BaseTest;
import io.qameta.allure.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web UI Automation")
@Feature("authenticate and security")
@Story("login by form")
@Tag("smoke")
@Tag("login")
public class LoginTest extends BaseTest {

    @Test
    //@Order1
    void login_Success() {
        LoginPage page = new LoginPage();
        page.openPage();
        page.login("tomsmith", "SuperSecretPassword!");

        assertTrue(page.isLoginSuccess());
    }
    
    @Test
    //@Order2
    void login_Failed() {
        LoginPage page = new LoginPage();
        page.open();
        page.login("wrong", "SuperSecretPword!");

        assertTrue(page.isLoginFail());
    }
}






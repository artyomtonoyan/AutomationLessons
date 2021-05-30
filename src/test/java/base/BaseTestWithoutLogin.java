package base;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.pages.HomePage;

import static setup.DriverSetup.getWebDriver;

public class BaseTestWithoutLogin {

    @BeforeMethod
    public void opening() {
        new HomePage();
        getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getWebDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        getWebDriver().manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        getWebDriver().navigate().refresh();
    }

    @AfterMethod
    public void exit() {
        getWebDriver().quit();
    }
}
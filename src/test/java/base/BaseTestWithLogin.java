package base;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.pages.CreatePage;

import static setup.DriverSetup.getWebDriver;

public class BaseTestWithLogin {
    @BeforeMethod
    public void loginAndDisablingPopUps() {
        CreatePage createPage = new CreatePage();
        getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getWebDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        getWebDriver().manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        getWebDriver().manage().addCookie(new Cookie("user_key", "54f47d1d-fa5d-4a8a-a451-269ebd49dd3b"));
        getWebDriver().manage().addCookie(new Cookie("sid", "s%3ArDB4PXOg62aoX3PWRcvwciQ6gW_e0qON.%2BB1zlI3vRKecoXY6A6zmy7eIbgA6gBW3%2FEegimGWZxU"));
        getWebDriver().navigate().refresh();
        createPage.waitForAvatarToDisplayed();
    }

    @AfterMethod
    public void exit() {
        getWebDriver().quit();
    }
}
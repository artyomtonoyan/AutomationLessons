import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.pages.CreatePage;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getWebDriver;

public class LoginTest {

    @Test
    public void loginWithKey() {
        CreatePage createPage = new CreatePage();
        getWebDriver().manage().addCookie(new Cookie("user_key", "bef03e78-0cf8-441c-a435-9e260837b963"));
        getWebDriver().manage().addCookie(new Cookie("sid", "s%3A33DFW1KoV1vFX_WkurfMrKZc_JSm0AYb.WWutsI6a2xIbRwdYxrS4vIoakvzA7gxX3YLAH%2BK2ORM"));
        getWebDriver().navigate().refresh();
        assertTrue(createPage.isUserLoggedIn(), "User was not logged in!");
    }

    @AfterMethod
    public void exit() {
        getWebDriver().quit();
    }
}
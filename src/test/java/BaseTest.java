import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static setup.DriverSetup.getWebDriver;

public class BaseTest {
    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage();
        getWebDriver().manage().addCookie(new Cookie("user_key", "54f47d1d-fa5d-4a8a-a451-269ebd49dd3b"));
        getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getWebDriver().manage().addCookie((new Cookie("sid", "s%3A33DFW1KoV1vFX_WkurfMrKZc_JSm0AYb.WWutsI6a2xIbRwdYxrS4vIoakvzA7gxX3YLAH%2BK2ORM")));
        getWebDriver().navigate().refresh();
        loginPage.waitForAvatarToDisplayed();
    }

    @AfterMethod
    public void exit() {
//        getWebDriver().quit();
    }
}
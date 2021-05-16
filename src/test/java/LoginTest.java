import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getWebDriver;

public class LoginTest {

    @AfterMethod
    public void exit() {
        getWebDriver().quit();
    }

    @Test
    public void loginWithKey() {
        LoginPage loginPage = new LoginPage();
        Cookie userKeyCookie = new Cookie("user_key", "54f47d1d-fa5d-4a8a-a451-269ebd49dd3b");
        getWebDriver().manage().addCookie(userKeyCookie);
        getWebDriver().navigate().refresh();

        assertTrue(loginPage.isUserLoggedIn(), "User was not logged in!");
    }
}
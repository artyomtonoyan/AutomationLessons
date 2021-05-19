import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static setup.DriverSetup.getWebDriver;

public class BaseTest {
    @BeforeMethod
    public void login() {
        new LoginPage();
        getWebDriver().manage().addCookie(new Cookie("user_key", "54f47d1d-fa5d-4a8a-a451-269ebd49dd3b"));
        getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getWebDriver().navigate().refresh();
    }

    @AfterMethod
    public void exit() {
//        getWebDriver().quit();
    }
}
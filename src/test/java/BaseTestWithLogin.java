import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static setup.DriverSetup.getWebDriver;

public class BaseTestWithLogin {
    @BeforeMethod
    public void loginAndDisablingPopUps() {
        CreatePage createPage = new CreatePage();
        getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getWebDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        getWebDriver().manage().addCookie(new Cookie("we-editor-photo-first-open", "true"));
        getWebDriver().manage().addCookie(new Cookie("user_key", "3a659f50-4b8a-448c-9cb9-5314f6af98bd"));
        getWebDriver().manage().addCookie(new Cookie("sid", "s%3AQu4jOceRdew_oLMaaZIOE9_yG27o9rmK.2iCxlTpZkWBk5vOFWGO8KXGB1lm5Y4WbUKf4ZICNrnc"));
        getWebDriver().navigate().refresh();
        createPage.waitForAvatarToDisplayed();
    }

    @AfterMethod
    public void exit() {
//        getWebDriver().quit();
    }
}
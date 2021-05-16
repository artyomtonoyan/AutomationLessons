import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getWebDriver;


public class EditorTest {
    @BeforeMethod
    public void login() {
        new LoginPage();
        Cookie userKeyCookie = new Cookie("user_key", "54f47d1d-fa5d-4a8a-a451-269ebd49dd3b");
        getWebDriver().manage().addCookie(userKeyCookie);
        getWebDriver().navigate().refresh();
    }

    @AfterMethod
    public void exit() {
        getWebDriver().quit();
    }

    @Test
    public void editorOpen() {
        EditorPage editorPage = new EditorPage();
        editorPage.uploadPhoto("/Users/artyomtonoyan/AutomationHomeworks/src/main/resources/fortest.jpeg");

        assertTrue(editorPage.isEditorOpen(), "Editor screen is not opened");
    }
}
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static setup.DriverSetup.getWebDriver;


public class EditorTest extends BaseTest{

    @Test
    public void editorOpen() {
        EditorPage editorPage = new EditorPage();
        editorPage.clickInstagramStory();
        editorPage.changeTab(1);
        Cookie myCookie = new Cookie("we-editor-first-open", "true");
        getWebDriver().manage().addCookie(myCookie);
        getWebDriver().navigate().refresh();
        editorPage.clickOnFitIcon();
        assertEquals(editorPage.getCountOfItemsInSideBar(), 28, "It's not 28");
    }

    @Test
    public void uploadPhoto() {
        EditorPage editorPage = new EditorPage();
        editorPage.uploadPhoto("/Users/artyomtonoyan/AutomationHomeworks/src/main/resources/fortest.jpeg");
    }
}
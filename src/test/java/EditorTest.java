import base.BaseTestWithLogin;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.pages.CreatePage;
import pageobjects.pages.EditorPage;

import static org.testng.Assert.*;
import static setup.DriverSetup.getWebDriver;


public class EditorTest extends BaseTestWithLogin {

    @Test
    public void countOfItemsInSideBarOfEditorTest() {
        CreatePage createPage = new CreatePage();
        createPage.clickInstagramStory();
        createPage.changeTab(1);
        EditorPage editorPage = new EditorPage();
        editorPage.clickOnFitIcon();
        editorPage.initialize();
        assertEquals(editorPage.getCountOfItemsInSideBar(), 28, "The count of items in Side Bar is not 28");
    }

    @Test
    public void uploadPhoto() {
        CreatePage createPage = new CreatePage();
        createPage.uploadPhoto("/Users/artyomtonoyan/AutomationHomeworks/src/main/resources/mytest.jpg");
        assertEquals(getWebDriver().getCurrentUrl(), "https://picsartstage2.com/create/editor", "Upload unsuccessful!");
    }

    @Test
    public void downloadFunctionalityFromEditor(){
        EditorPage editorPage = new EditorPage("?templateSize=insta_story");
        editorPage.clickOnDownloadButton();
        editorPage.clickOnDownloadButtonInModal();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(editorPage.isDownloadSuccessfulDialogOpened(), "Download unsuccessful");
        softAssert.assertTrue(editorPage.isFileDownloaded(), "File is not downloaded");
        softAssert.assertAll();
    }

    @Test
    public void openContextMenuInCanvas() {
        EditorPage editorPage = new EditorPage("?templateSize=insta_story");
        editorPage.rightClickOnCanvas();
        editorPage.initialize();
        assertTrue(editorPage.isContextMenuOpened(), "Context Menu doesn't open");
    }
}
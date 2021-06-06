import base.BaseTestWithLogin;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.components.editor.FitComponent;
import pageobjects.dialogs.DownloadDialog;
import pageobjects.dialogs.DownloadSuccessDialog;
import pageobjects.pages.CreatePage;
import pageobjects.pages.EditorPage;

import static org.testng.Assert.*;
import static setup.DriverSetup.getWebDriver;


public class EditorTest extends BaseTestWithLogin {

    @Test
    public void countOfItemsInSideBarOfEditorTest() {
        EditorPage editorPage = new CreatePage().clickInstagramStory();
        editorPage.changeTab(1);
        FitComponent editorFitComponent = editorPage.clickOnFitIcon();
        assertEquals(editorFitComponent.getCountOfItemsInSideBar(), 28, "The count of items in Side Bar is not 28");
    }

    @Test
    public void uploadPhoto() {
        new CreatePage().uploadPhoto("/Users/artyomtonoyan/AutomationHomeworks/src/main/resources/mytest.jpg");
        assertEquals(getWebDriver().getCurrentUrl(), "https://picsartstage2.com/create/editor", "Upload unsuccessful!");
    }

    @Test
    public void downloadFunctionalityFromEditor() {
        new EditorPage("?templateSize=insta_story")
                .clickOnDownloadButton()
                .clickOnDownloadButtonInModal();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new DownloadSuccessDialog().isDownloadSuccessfulDialogOpened(), "Download unsuccessful");
        softAssert.assertTrue(new DownloadDialog().isFileDownloaded(), "File is not downloaded");
        softAssert.assertAll();
    }

    @Test
    public void openContextMenuInCanvas() {
        new EditorPage("?templateSize=insta_story").rightClickOnCanvas();
        assertTrue(new EditorPage().isContextMenuOpened(), "Context Menu doesn't open");
    }
}
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EditorTest extends BaseTestWithoutLogin {

    @Test
    public void editorOpen() {
        CreatePage createPage = new CreatePage();
        createPage.clickInstagramStory();
        createPage.changeTab(1);
        EditorPage editorPage = new EditorPage();
        editorPage.clickOnFitIcon();
        assertEquals(editorPage.getCountOfItemsInSideBar(), 28, "The count of items in Side Bar is not 28");
    }

    @Test
    public void uploadPhoto() {
        CreatePage createPage = new CreatePage();
        createPage.uploadPhoto("/Users/artyomtonoyan/AutomationHomeworks/src/main/resources/fortest.jpeg");
    }

    @Test
    public void downloadFunctionalityFromEditor() {
        EditorPage editorPage = new EditorPage();
        editorPage.open("?templateSize=insta_story");
        editorPage.clickOnDownloadButton();
        editorPage.clickOnDownloadButtonInModal();
        assertTrue(editorPage.isDownloadSuccessfulDialogOpened(), "Download unsuccessful");
        //Another option to check whether the file is downloaded to folder or not
//        assertTrue(editorPage.isFileDownloaded(), "File is not downloaded");
    }
}
import base.BaseTestWithLogin;
import org.testng.annotations.Test;
import pageobjects.pages.ImageBrowserPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ImageBrowserTestOld extends BaseTestWithLogin {

    @Test
    public void likeAndDislikeTest() {
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage("359193804035201");
        if (imageBrowserPage.isLikedOld()) {
            imageBrowserPage.clickOnLikeIcon();
            assertFalse(imageBrowserPage.isLikedOld(), "Wasn't disliked");
            imageBrowserPage.clickOnLikeIcon();
            assertTrue(imageBrowserPage.isLikedOld(), "Wasn't liked");
        } else {
            imageBrowserPage.clickOnLikeIcon();
            assertTrue(imageBrowserPage.isLikedOld(), "Wasn't liked");
            imageBrowserPage.clickOnLikeIcon();
            assertFalse(imageBrowserPage.isLikedOld(), "Wasn't disliked");
        }
    }
}
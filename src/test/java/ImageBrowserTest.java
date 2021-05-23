import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ImageBrowserTest extends BaseTestWithLogin {
    @Test
    public void likeAndDislikeTest() {
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage();
        if (imageBrowserPage.isLiked()) {
            imageBrowserPage.clickOnLikeIcon();
            assertFalse(imageBrowserPage.isLiked(), "Wasn't disliked");
            imageBrowserPage.clickOnLikeIcon();
            assertTrue(imageBrowserPage.isLiked(), "Wasn't liked");

        } else {
            imageBrowserPage.clickOnLikeIcon();
            assertTrue(imageBrowserPage.isLiked(), "Wasn't liked");
            imageBrowserPage.clickOnLikeIcon();
            assertFalse(imageBrowserPage.isLiked(), "Wasn't disliked");
        }
    }
}
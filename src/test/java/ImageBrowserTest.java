import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.pages.CreatePage;
import pageobjects.pages.ImageBrowserPage;
import utilities.ApiHelper;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getWebDriver;

public class ImageBrowserTest {
    private String key;
    private String photoId;

    @BeforeMethod
    public void setup() throws IOException {
        new CreatePage();
        key = (ApiHelper.createUser()).get("response").getAsJsonObject().get("key").getAsString();
        getWebDriver().manage().addCookie(new Cookie("user_key", key));
        getWebDriver().navigate().refresh();
        photoId = (ApiHelper.uploadPhoto(key)).get("id").getAsString();
    }

    @Test
    public void addingHashtagsToExistingImage() throws IOException {
        ApiHelper.addHashtagToExistingPhoto(photoId, key, ImageBrowserPage.HASHTAGS);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(photoId);
        assertTrue(imageBrowserPage.isHashtagsAdded(), "Hashtags were not being added successfully!");
    }

    @Test
    public void likePhoto() throws IOException {
        ApiHelper.likePhoto(key, photoId);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(photoId);
        assertTrue(imageBrowserPage.isLiked(), "Image wasn't liked!");

    }

    @AfterMethod
    public void close() throws IOException {
        ApiHelper.deleteUser(key);
        getWebDriver().quit();
    }
}
import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getWebDriver;

public class ImageBrowserTestNew {
    private String key;
    private String photoId;

    @BeforeMethod
    public void setup() throws IOException {
        key = (ApiHelper.createUser()).get("response").getAsJsonObject().get("key").getAsString();
        new CreatePage();
        getWebDriver().manage().addCookie(new Cookie("user_key", key));
        getWebDriver().navigate().refresh();
        photoId = (ApiHelper.uploadPhoto(key)).get("id").getAsString();

    }

    @Test
    public void addingHashtagsToExistingImage() throws IOException {
        JsonObject editPhoto = ApiHelper.addHashtagToExistingPhoto(photoId, key, ImageBrowserPage.HASHTAGS);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(photoId);
        assertTrue(imageBrowserPage.isHashtagsAdded(), "Hashtags were not being added successfully!");
    }

    @Test
    public void likePhoto() throws IOException {
        JsonObject likePhoto = ApiHelper.likePhoto(key, photoId);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(photoId);
        assertTrue(imageBrowserPage.isLiked(), "Image wasn't liked!");

    }

    @AfterMethod
    public void close() throws IOException {
        JsonObject deleteUser = ApiHelper.deleteUser(key);
        getWebDriver().navigate().refresh();
//        getWebDriver().quit();
    }
}
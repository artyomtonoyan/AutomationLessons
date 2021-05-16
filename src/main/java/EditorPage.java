import org.openqa.selenium.By;

public class EditorPage extends BasePage {
    private final By uploadButtonLocation = By.cssSelector("[accept='image/jpeg, image/png, image/gif']");
    private final By downloadButton = By.id("download-button");

    public void uploadPhoto(String path) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        type(uploadButtonLocation, path);
    }

    public boolean isEditorOpen() {
        try {
            waitUntilExpectedCondition(driver, 20, downloadButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getURL() {
        return BASE_URL + "create/editor";
    }
}
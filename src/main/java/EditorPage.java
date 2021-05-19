import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class EditorPage extends BasePage {
    private final By uploadButtonLocation = By.cssSelector("[accept='image/jpeg, image/png, image/gif']");
    private final By instagramStoryLocation = By.cssSelector("[data-test='insta-story']");
    private final By itemsInSideBarLocation = By.cssSelector(("[class*='customSizeContainer']"));
    private final By fitIconLocation = By.id("background-category");

    public EditorPage() {
        open(getURL());
    }

    public void uploadPhoto(String path) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Why Doesn't work with wait?
//        WaitHelper.getInstance().waitForElementToDisplayed(uploadButtonLocation);
        type(uploadButtonLocation, path);
    }

    public void clickInstagramStory() {
        WaitHelper.getInstance().waitForElementToDisplayed(instagramStoryLocation);
        Actions actions = new Actions(driver);
        actions.moveToElement(find(instagramStoryLocation)).click().build().perform();
    }

    public int getCountOfItemsInSideBar() {
        WaitHelper.getInstance().waitForElementToDisplayed(itemsInSideBarLocation);
        return findAll(itemsInSideBarLocation).size();
    }

    public void clickOnFitIcon() {
        WaitHelper.getInstance().waitForElementToDisplayed(fitIconLocation);
        click(fitIconLocation);
    }
    @Override
    public String getURL() {
        return BASE_URL_PICSART + "create";
    }
}
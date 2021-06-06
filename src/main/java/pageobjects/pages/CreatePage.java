package pageobjects.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;
import utilities.WaitHelper;

import static setup.DriverSetup.getWebDriver;

public class CreatePage extends PageBase {

    @FindBy(css = "[data-test='insta-story']")
    private WebElement instagramStory;

    @FindBy(css = "[accept='image/jpeg, image/png, image/gif']")
    private WebElement uploadButton;

    @FindBy(css = "[class*=uploadButtonWrapper] button")
    private WebElement uploadButtonOuterPart;

    @FindBy(css = ".pa-uiLib-headerProfileInfo-avatar")
    private WebElement avatar;

    @FindBy(css = "[data-test='insta-profile']")
    private WebElement instagramProfile;

    private static final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();

    public CreatePage() {
        open(getURL());
        PageFactory.initElements(driver, this);
    }

    public void uploadPhoto(String path) {
        type(uploadButton, path);
    }

    public EditorPage clickInstagramStory() {
        Actions actions = new Actions(driver);
        actions.moveToElement(instagramStory).click().build().perform();
        return new EditorPage();
    }

    public boolean isAvatarDisplayed() {
        return isDisplayed(avatar);
    }

    public boolean isUserLoggedIn() {
        try {
            WaitHelper.getInstance().waitForElementToDisplayed(avatar);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public EditorPage clickOnInstagramProfile() {
        javascriptExecutor.executeScript("arguments[0].click()", instagramProfile);
        return new EditorPage();
    }

    public void waitForAvatarToDisplayed() {
        WaitHelper.getInstance().waitForElementToDisplayed(avatar);
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "create";
    }
}
package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pageobjects.base.BasePage;
import utilities.WaitHelper;

import static setup.DriverSetup.getWebDriver;

public class CreatePage extends BasePage {

    private final By instagramStoryLocation = By.cssSelector("[data-test='insta-story']");
    private final By uploadButtonLocation = By.cssSelector("[accept='image/jpeg, image/png, image/gif']");
    private final By uploadButtonOuterPartLocation = By.cssSelector("[class*=uploadButtonWrapper] button");
    private final By avatarLocation = By.cssSelector(".pa-uiLib-headerProfileInfo-avatar");
    private final By instagramProfileLocation = By.cssSelector("data-test='insta-profile'");

    private static JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();

    public CreatePage() {
        open(getURL());
    }

    public void uploadPhoto(String path) {
        WaitHelper.getInstance().waitForElementToDisplayed(uploadButtonOuterPartLocation);
        type(uploadButtonLocation, path);
    }

    public void clickInstagramStory() {
        WaitHelper.getInstance().waitForElementToDisplayed(instagramStoryLocation);
        Actions actions = new Actions(driver);
        actions.moveToElement(find(instagramStoryLocation)).click().build().perform();
    }

    public boolean isAvatarDisplayed() {
        return isDisplayed(avatarLocation);
    }

    public boolean isUserLoggedIn() {
        try {
            WaitHelper.getInstance().waitForElementToDisplayed(avatarLocation);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public void clickOnInstagramProfile() {
        javascriptExecutor.executeScript("arguments[0].click()", find(instagramProfileLocation));
    }

    public void waitForAvatarToDisplayed() {
        WaitHelper.getInstance().waitForElementToDisplayed(avatarLocation);
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "create";
    }


}
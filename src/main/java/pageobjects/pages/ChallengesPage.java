package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.base.BasePage;
import utilities.WaitHelper;

import java.util.List;

public class ChallengesPage extends BasePage {

    private final By activeChallengeCardLocation = By.cssSelector(".grid-cards .card");

    public void clickOnRandomActiveChallenge() {
        WaitHelper.getInstance().waitForElementToDisplayed(activeChallengeCardLocation);
        List<WebElement> webElementList = findAll(activeChallengeCardLocation);
        click(webElementList.get((int) (Math.random() * (webElementList.size() + 1))));
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "challenges";
    }
}
package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;

public class ChallengePage extends PageBase {

    @FindBy(css = "[data-js-get-the-app-popup-source='challenge-landing']")
    private WebElement participateButton;

    public ChallengePage() {
        PageFactory.initElements(driver, this);
    }

    public ChallengePage(String id) {
        open(getURL() + "/" + id);
        PageFactory.initElements(driver, this);
    }

    public void clickOnParticipateButton() {
        click(participateButton);
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "challenge";
    }
}
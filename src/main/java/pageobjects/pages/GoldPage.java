package pageobjects.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;

import java.time.Duration;
import java.util.List;

import static setup.DriverSetup.getWebDriver;

public class GoldPage extends PageBase {

    private static final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();

    @FindBy(css = ".layout-content-main > div:nth-child(2) > div > ul li")
    private List<WebElement> slideshowDots;

    @FindBy(css = ".c0233")
    private WebElement carouselContainer;

    public GoldPage() {
        open(getURL());
        PageFactory.initElements(driver, this);
    }

    public int getSizeOfSlideshowDots() {
        return slideshowDots.size();
    }

    public void clickOnSlideshowDot(int index) {
        javascriptExecutor.executeScript("arguments[0].click()", slideshowDots.get(index));
    }

    public boolean isSlideActive(int index) {
        return slideshowDots.get(index).getAttribute("class").contains("active");
    }

    public void changeCarouselWithActions() {
        Actions actions = new Actions(driver);
        actions.moveToElement(carouselContainer)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(carouselContainer)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(10, 2)
                .release().perform();
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "gold";
    }
}

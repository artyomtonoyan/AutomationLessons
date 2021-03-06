package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pageobjects.base.PageBase;
import utilities.WaitHelper;

import java.time.Duration;

public class DesmosPageForWaitAndActionsExercise extends PageBase {

    private final By graphingCalculatorButtonLocation = By.cssSelector("[href='/calculator'].dcg-shared-btn-blue");
    private final By secondExpressionField = By.className("dcg-new-expression-fade");
    private final By rightNavbarLocation = By.className("align-right-container");
    private final By firstExpressionTextArea = By.cssSelector("textarea[aria-label='Expression 1:']");
    private final By graphingArea = By.className("dcg-graph-outer");

    public DesmosPageForWaitAndActionsExercise() {
        open(getURL());
    }

    public void clickOnGraphingCalculatorButton() {
        WaitHelper.getInstance().waitForElementToDisplayed(graphingCalculatorButtonLocation);
        click(find(graphingCalculatorButtonLocation));
    }

    public void clickSecondExpressionField() {
        WaitHelper.getInstance().waitForElementToDisplayed(secondExpressionField);
        click(secondExpressionField);
    }

    public boolean isLoginButtonTextAppeared() {
        try {
            WaitHelper.getInstance().waitForTextToBePresentInElement(find(rightNavbarLocation), "Log In");
            return true;
        } catch (Error error) {
            return false;
        }
    }

    public boolean isAlertMessageAppeared() {
        try {
            WaitHelper.getInstance().waitForAlertMessage();
            return true;
        } catch (Error error) {
            return false;
        }
    }

    public void typeFormulaAndChangePositionOfGraph(String formula) {
        WaitHelper.getInstance().waitForElementToDisplayed(firstExpressionTextArea);
        type(firstExpressionTextArea, formula);
        Actions actions = new Actions(driver);
        actions.moveToElement(find(graphingArea))
                .pause(Duration.ofSeconds(1))
                .clickAndHold(find(graphingArea))
                .moveByOffset(100, 200)
                .moveByOffset(-100, -200)
                .moveByOffset(100, 200)
                .pause(Duration.ofSeconds(3))
                .release()
                .perform();
    }

    @Override
    public String getURL() {
        return "https://www.desmos.com/";
    }
}
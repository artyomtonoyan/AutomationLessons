import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.pages.DesmosPageForWaitAndActionsExercise;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getWebDriver;

public class WaitAndActionsExerciseTest {
    @Test
    public void waitTest() {
        DesmosPageForWaitAndActionsExercise desmosPage = new DesmosPageForWaitAndActionsExercise();
        desmosPage.clickOnGraphingCalculatorButton();
        assertTrue(desmosPage.isLoginButtonTextAppeared(), "There is no Log-in text in right navbar");
        desmosPage.clickSecondExpressionField();
        getWebDriver().navigate().back();
        assertTrue(desmosPage.isAlertMessageAppeared(), "There is no Alert!");
    }

    @Test(enabled = false)
    public void actionTest() {
        DesmosPageForWaitAndActionsExercise desmosPage = new DesmosPageForWaitAndActionsExercise();
        desmosPage.clickOnGraphingCalculatorButton();
        desmosPage.typeFormulaAndChangePositionOfGraph("y=cos(x)");
    }

    @AfterMethod
    public void exit() {
        getWebDriver().quit();
    }
}
package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static setup.DriverSetup.getWebDriver;
import static utilities.DateAndTimeHelper.getCurrentDateAndTime;
import static utilities.FileHelper.write;

public class WaitHelper {
    private final static int DEFAULT_TIMEOUT = 20;
    private final static Logger LOGGER = Logger.getLogger(WaitHelper.class);

    public static WaitHelper getInstance() {
        return new WaitHelper();
    }

    public void waitForElementToDisplayed(By location) {
        try {
            String message = "Waiting for the element by locator to appear: " + location.toString();
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        try {
            new WebDriverWait(getWebDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated((location)));
        } catch (WebDriverException e) {
            throw new Error("Element with provided locations was not found: " + location.toString());
        }
    }

    public void waitForElementToDisplayed(WebElement element) {
        try {
            String message = "Waiting for the element to appear: " + element.toString();
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        try {
            new WebDriverWait(getWebDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOf((element)));
        } catch (WebDriverException e) {
            throw new Error("Element was not found: " + element.toString());
        }
    }

    public void waitForAlertMessage() {
        try {
            String message = "Waiting for alert message to appear: ";
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        try {
            new WebDriverWait(getWebDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.alertIsPresent());
        } catch (WebDriverException e) {
            throw new Error("No Alert Message: ");
        }
    }

    public void waitForTextToBePresentInElement(WebElement element, String text) {
        try {
            String message = "Waiting for text to appear in the element: " + element.toString();
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        try {
            new WebDriverWait(getWebDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (WebDriverException e) {
            throw new Error("Text in the element was not found: " + element.toString());
        }
    }
}
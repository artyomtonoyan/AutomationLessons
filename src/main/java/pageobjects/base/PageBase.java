package pageobjects.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static setup.DriverSetup.getWebDriver;
import static utilities.DateAndTimeHelper.getCurrentDateAndTime;
import static utilities.FileHelper.write;

public abstract class PageBase {
    private static final Logger LOGGER = Logger.getLogger(PageBase.class);
    protected WebDriver driver;
    protected static final String BASE_URL_PICSART = System.getProperty("selenium.url", "http://picsartstage2.com/");

    public PageBase() {
        this.driver = getWebDriver();
        try {
            String message = "Setting Driver: " + driver.toString();
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
    }

    public abstract String getURL();

    public void open(String url) {
        try {
            String message = "Opening: " + url;
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        driver.get(url);
    }

    public WebElement find(By location) {
        try {
            String message = "Finding the element by the following location: " + location.toString();
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        return driver.findElement(location);
    }

    /**
     * public List<WebElement> findAll(By location) {
     * try {
     * String message = "Finding all elements by the following location: " + location.toString();
     * LOGGER.info(message);
     * write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
     * } catch (IOException e) {
     * LOGGER.error("File not found / Can't write: Current log can't be saved");
     * }
     * return driver.findElements(location);
     * }
     **/
    public void type(WebElement element, String input) {
        try {
            String message = "Writing: \"" + input + "\" in the element: " + element.toString();
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        element.sendKeys(input);
    }

    public void type(By location, String input) {
        type(find(location), input);
    }

    public void click(WebElement element) {
        try {
            String message = "Clicking on the element: " + element.toString();
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        element.click();
    }

    public void click(By location) {
        click(find(location));
    }


    public boolean isDisplayed(WebElement element) {
        try {
            String message = getCurrentDateAndTime() + ": " + "Checking is the element displayed: " + element.toString();
            System.out.println(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * public boolean isDisplayed(By location) {
     * try {
     * String message = "Checking whether the element by locator displayed: " + location.toString();
     * LOGGER.info(message);
     * write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
     * } catch (IOException e) {
     * LOGGER.error("File not found / Can't write: Current log can't be saved");
     * }
     * try {
     * return find(location).isDisplayed();
     * } catch (NoSuchElementException e) {
     * LOGGER.error("The element is not displayed: " + location.toString());
     * return false;
     * }
     * }
     **/
    public void changeTab(int tabIndex) {
        try {
            String message = "Switching to tab by the index of: " + tabIndex;
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        List<String> windowHandlers = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(windowHandlers.get(tabIndex));
    }
}
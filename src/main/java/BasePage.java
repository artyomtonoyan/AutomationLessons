import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static setup.DriverSetup.getWebDriver;
import static utilities.DateAndTimeService.getCurrentDateAndTime;
import static utilities.FileService.write;

public abstract class BasePage {
    protected WebDriver driver;
    public static final String BASE_URL = "https://picsartstage2.com/";

    public BasePage() {
        this.driver = getWebDriver();
    }

    public abstract String getURL();

    public void open(String url) {
        try {
            String message = getCurrentDateAndTime() + ": " + "Opening: " + url;
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        driver.get(url);
    }

    public WebElement find(By location) {
        try {
            String message = getCurrentDateAndTime() + ": " + "Find element: " + location.toString();
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        return driver.findElement(location);
    }

    public void type(WebElement element, String input) {
        try {
            String message = getCurrentDateAndTime() + ": " + "Writing: " + input + " in: " + element.toString();
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        element.sendKeys(input);
    }

    public void type(By location, String input) {
        type(find(location), input);
    }

    public void click(WebElement element) {
        try {
            String message = getCurrentDateAndTime() + ": " + "Clicking on the element: " + element.toString();
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        element.click();
    }

    public void click(By location) {
        click(find(location));
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement waitUntilExpectedCondition(WebDriver driver, int seconds, By locator) {
        try {
            String message = getCurrentDateAndTime() + ": " + "Waiting for the element by locator to appear: " + locator.toString();
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        return new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOfElementLocated((locator)));
    }
}
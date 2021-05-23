import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static setup.DriverSetup.getWebDriver;
import static utilities.DateAndTimeService.getCurrentDateAndTime;
import static utilities.FileService.write;

public abstract class BasePage {
    protected WebDriver driver;
    public static final String BASE_URL_PICSART = "https://picsartstage2.com/";

    public BasePage() {
        this.driver = getWebDriver();
        try {
            String message = getCurrentDateAndTime() + ": " + "Setting Driver: " + driver.toString();
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
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
            String message = getCurrentDateAndTime() + ": " + "Finding the element: " + location.toString();
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        return driver.findElement(location);
    }

    public List<WebElement> findAll(By location) {
        try {
            String message = getCurrentDateAndTime() + ": " + "Finding all elements: " + location.toString();
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        return driver.findElements(location);
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

    /**
     * public boolean isDisplayed(WebElement element) {
     * try {
     * String message = getCurrentDateAndTime() + ": " + "Checking is the element displayed: " + element.toString();
     * System.out.println(message);
     * write("src/files/logs.txt", "\n" + message);
     * } catch (IOException e) {
     * System.out.println("File not found / Can't write: Current log can't be saved");
     * }
     * try {
     * return element.isDisplayed();
     * } catch (NoSuchElementException e) {
     * return false;
     * }
     * }
     **/
    public boolean isDisplayed(By location) {
        try {
            String message = getCurrentDateAndTime() + ": " + "Checking is the element by locator displayed: " + location.toString();
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void changeTab(int tabIndex) {
        try {
            String message = getCurrentDateAndTime() + ": " + "Switching to tab by the index of: " + tabIndex;
            System.out.println(message);
            write("src/files/logs.txt", "\n" + message);
        } catch (IOException e) {
            System.out.println("File not found / Can't write: Current log can't be saved");
        }
        List<String> windowHandlers = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(windowHandlers.get(tabIndex));
    }
}
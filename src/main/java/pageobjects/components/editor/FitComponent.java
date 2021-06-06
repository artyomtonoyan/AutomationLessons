package pageobjects.components.editor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;
import utilities.WaitHelper;

import java.util.List;

public class FitComponent extends PageBase {

    @FindBy(css = "[class*='customSizeContainer']")
    private List<WebElement> itemsInSideBar;

    public FitComponent() {
        PageFactory.initElements(driver, this);
    }

    public int getCountOfItemsInSideBar() {
        WaitHelper.getInstance().waitForElementToDisplayed(By.cssSelector("[class*='customSizeContainer']"));
        return itemsInSideBar.size();
    }

    @Override
    public String getURL() {
        return null;
    }
}
package pageobjects.dialogs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;
import utilities.WaitHelper;

public class DownloadSuccessDialog extends PageBase {

    @FindBy(className = "ReactModal__Content")
    private WebElement downloadSuccessfulDialog;

    public DownloadSuccessDialog() {
        PageFactory.initElements(driver, this);
    }

    public boolean isDownloadSuccessfulDialogOpened() {
        try {
            WaitHelper.getInstance().waitForElementToDisplayed(downloadSuccessfulDialog);
            return true;
        } catch (Error error) {
            return false;
        }
    }

    @Override
    public String getURL() {
        return null;
    }
}
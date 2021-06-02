package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.BasePage;
import utilities.WaitHelper;

import java.util.List;

import static utilities.FileHelper.isFileExistsInDirectory;

public class EditorPage extends BasePage {

    @FindBy(css = "[class*='customSizeContainer']")
    private List<WebElement> itemsInSideBar;

    @FindBy(id = "background-category")
    private WebElement fitIcon;

    @FindBy(id = "download-button")
    private WebElement downloadButton;

    @FindBy(css = "[data-test='downloaded-button']")
    private WebElement downloadButtonInModal;

    @FindBy(className = "ReactModal__Content")
    private WebElement downloadSuccessfulDialog;

    @FindBy(css = "[data-test='downloaded-file-name']")
    private WebElement fileName;

    @FindBy(css = "[data-test='unit'] span")
    private WebElement extensionOfDownloadableFile;

    @FindBy(css = "[data-test='canvas-container'] .konvajs-content")
    private WebElement canvas;

    @FindBy(id = "context-menu")
    private WebElement contextMenu;

    private String nameOfFile;
    private String extensionOfFile;

    public EditorPage() {
        PageFactory.initElements(driver, this);
    }

    public EditorPage(String endOfUrl) {
        super.open(getURL() + endOfUrl);
        PageFactory.initElements(driver, this);
    }

    public int getCountOfItemsInSideBar() {
        WaitHelper.getInstance().waitForElementToDisplayed(By.cssSelector("[class*='customSizeContainer']"));
        return itemsInSideBar.size();
    }

    public void clickOnFitIcon() {
        click(fitIcon);
    }

    public void clickOnDownloadButton() {
        click(downloadButton);
        nameOfFile = fileName.getAttribute("value");
        extensionOfFile = extensionOfDownloadableFile.getText().toLowerCase();
    }

    public void clickOnDownloadButtonInModal() {
        WaitHelper.getInstance().waitForTextToBePresentInElement(downloadButtonInModal, "Download");
        click(downloadButtonInModal);
    }

    public boolean isDownloadSuccessfulDialogOpened() {
        try {
            WaitHelper.getInstance().waitForElementToDisplayed(downloadSuccessfulDialog);
            return true;
        } catch (Error error) {
            return false;
        }
    }

    public String getNameOfTheDownloadableFile() {
        return nameOfFile;
    }

    public String getExtensionOfDownloadableFile() {
        return extensionOfFile;
    }


    public boolean isFileDownloaded() {
        return isFileExistsInDirectory("/Users/artyomtonoyan/Documents", getNameOfTheDownloadableFile(), getExtensionOfDownloadableFile());
    }

    public void rightClickOnCanvas() {
        Actions actions = new Actions(driver);
        actions.contextClick(canvas).perform();
    }

    public boolean isContextMenuOpened() {
        return contextMenu.getAttribute("style").contains("flex");
    }

    public EditorPage initialize() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "create/editor";
    }
}
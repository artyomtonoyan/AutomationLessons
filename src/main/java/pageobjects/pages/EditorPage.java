package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;
import pageobjects.components.editor.FitComponent;
import pageobjects.dialogs.DownloadDialog;

public class EditorPage extends PageBase {

    @FindBy(id = "background-category")
    private WebElement fitIcon;

    @FindBy(id = "download-button")
    private WebElement downloadButton;

    @FindBy(css = "[data-test='canvas-container'] .konvajs-content")
    private WebElement canvas;

    @FindBy(id = "context-menu")
    private WebElement contextMenu;

    public EditorPage() {
        PageFactory.initElements(driver, this);
    }

    public EditorPage(String endOfUrl) {
        super.open(getURL() + endOfUrl);
        PageFactory.initElements(driver, this);
    }

    public FitComponent clickOnFitIcon() {
        click(fitIcon);
        return new FitComponent();
    }

    public DownloadDialog clickOnDownloadButton() {
        click(downloadButton);
        return new DownloadDialog();
    }

    public void rightClickOnCanvas() {
        Actions actions = new Actions(driver);
        actions.contextClick(canvas).perform();
        new EditorPage();
    }

    public boolean isContextMenuOpened() {
        return contextMenu.getAttribute("style").contains("flex");
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "create/editor";
    }
}
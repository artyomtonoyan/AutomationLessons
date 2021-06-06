package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;

import java.util.ArrayList;
import java.util.List;

public class ImageBrowserPage extends PageBase {
    public static final String[] HASHTAGS = {"#MYTEST", "#HELLO", "#DDDD"};

    @FindBy(css = ".actions-section .notifier-hover-toggle .like")
    private WebElement likeIcon;

    @FindBy(css = ".description a")
    private List<WebElement> descriptionHashtagsList;

    @FindBy(css = ".notifier-hover-toggle .js-likes-count")
    private WebElement likesCountIcon;

    public ImageBrowserPage(String imageId) {
        open(getURL() + imageId);
        PageFactory.initElements(driver, this);
    }

    public void clickOnLikeIcon() {
        click(likeIcon);
    }

    ArrayList<String> getHashtagsList() {
        ArrayList<String> hashtagsList = new ArrayList<>();
        for (WebElement hashtagElement : descriptionHashtagsList) {
            hashtagsList.add(hashtagElement.getText());
        }
        return hashtagsList;
    }

    public boolean isHashtagsAdded() {
        if (getHashtagsList().isEmpty()) {
            return false;
        }
        for (String hashtag : HASHTAGS) {
            if (!getHashtagsList().contains(hashtag)) {
                return false;
            }
        }
        return true;
    }

    public boolean isLikedOld() {
        return likeIcon.getAttribute("class").contains("active");
    }

    public boolean isLiked() {
        return likesCountIcon.getText().equals("1");
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "i/";
    }
}

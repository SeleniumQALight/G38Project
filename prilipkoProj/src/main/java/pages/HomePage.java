package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends ParentPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement userAvatar;


    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(userAvatar);
    }
}
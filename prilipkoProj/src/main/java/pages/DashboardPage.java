package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashboardPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement userAvatar;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(userAvatar);
    }
}
package mainPack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath =".//*[@class='pull-left image']" )
    WebElement avatar;

    public boolean isAvatarPresent() {
       return actionsWithOurElements.isAlementPresent(avatar);

    }

    public void goToThisPage() {
    }
}

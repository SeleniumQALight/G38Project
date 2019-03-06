package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(id="dictionary")
    private WebElement menuDictionary;
    @FindBy(id = "spares")
    private WebElement subMenuSpare;
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }



    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(avatar);
    }

    public void goToThisPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("Student", "909090");
        Assert.assertEquals("Avatar is not present",true,isAvatarPresent());
    }

    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare(){
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }
}

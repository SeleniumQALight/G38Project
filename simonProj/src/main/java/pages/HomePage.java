package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//*[@class='pull-left image']")
   private WebElement avatar;

    @FindBy(id = "dictionary")
    private WebElement mainMenuDictionary;

    @FindBy(id = "spare")
    private WebElement subMenuSpare;


    public boolean isAvatarPresent() {
      return actionWithOurElements.isElementPresent(avatar);
    }

    public void goToThisPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("Student", "909090");
        Assert.assertEquals("Avatar is not present", true, isAvatarPresent());


    }

    public void clickOnMenuDictionary() {
        actionWithOurElements.clickOnElement(mainMenuDictionary);

    }

    public void clickOnSubMenuSpare(){
        actionWithOurElements.clickOnElement(subMenuSpare);
    }
}

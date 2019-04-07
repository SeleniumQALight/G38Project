package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class HomePage extends ParentPage {

    @FindBy(id="dictionary")
    private WebElement menuDictionary;

    @FindBy(id="spares")
    private WebElement subMenuSpare;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath=".//*[@class='pull-left image']")
            private WebElement avatar;

    @Step
    public boolean isAvatarPresent() {
//        try {
//           return avatar.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }

          return actionsWithOurElements.isElementPresent(avatar);
    }

    @Step
    public void goToThisPage() {
        LoginPage loginPage =new LoginPage(webDriver);
        loginPage.login("Student", "909090");
        Assert.assertEquals("Avattar is not present",
                true, isAvatarPresent()
        );
    }

    @Step
    public  void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    @Step
    public void clickOnSubMenuSpare(){
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }
}

package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {




    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpare;

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement leftAvatar;

    @Step
    public boolean isAvatarPresent() {
        return actionsWithElements.isElementDisplayed(leftAvatar);
//        try {
//            return leftAvatar.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
    }

    @Step
    public void openToThisPage() {
        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.login("Student", "909090");
        Assert.assertEquals("Avatar is not present"
                , true, isAvatarPresent()
        );
    }

    @Step
    public  void  clickOnSubmenuSpare() {
        actionsWithElements.clickOnElement(subMenuSpare);
    }

    @Step
    public void clickOnMenuDictionary() {
        actionsWithElements.clickOnElement(menuDictionary);
    }
}

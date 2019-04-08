package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(id ="dictionary")
    private WebElement menuDictionary;

    @FindBy (id = "spares")
    private WebElement SubMenuSpare;

    @FindBy (xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    @FindBy(id = "service_apparat")
    private WebElement menuServices;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    @Step  //to add steps to allure
    public boolean isAvatarPresent() {

        return actionsWithOurElements.isElementPresent(avatar);

    }

    @Step
    public void goToHOMEPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("Student","909090");
        Assert.assertEquals("Avatar is not present", true, isAvatarPresent());
    }

    public void goToHOMEPageUsingCOOKIES(){

    }

    @Step
    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    @Step
    public void clickOnSubMenuSpare(){
        actionsWithOurElements.clickOnElement(SubMenuSpare);
    }

    @Step
    public void clickOnServiceMenu(){
        actionsWithOurElements.clickOnElement(menuServices);
    }
}
package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class HomePage extends ParentPage {
    @FindBy(id ="dictionary")
    private WebElement menuDictionary;

    @FindBy(id="spares")
    private WebElement subMenuSpare;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy (xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    public boolean isAvatarPresent() {
    return actionsWithOurElements.isElementPresent(avatar);

    }

    public void goToThisPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("Student", "909090");
       Assert.assertEquals("Avatar not present",true, isAvatarPresent());

    }

    public void clickOnMenuDictionary (){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }
    public void clickOnSubMenuSpare (){
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }
}

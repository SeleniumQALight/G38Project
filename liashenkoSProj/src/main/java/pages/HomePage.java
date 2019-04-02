package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PerentPage {

    @FindBy(xpath = "//*[@id='dictionary']")
    private WebElement menuDictionary;
    @FindBy(id="spares")
    private WebElement subMenuSpar;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    public boolean isAvatarPresent() {
      /*  try {
          return   avatar.isDisplayed();
        } catch (Exception e) {
            return false;
        }*/
      return  actionsWithOurElements.isElementPresent(avatar);


    }

    public void goToThisPage() {
        LoginPage loginPage=new LoginPage(webDriver);
        loginPage.login("Student","909090");
        Assert.assertEquals("Avatar is not present"
                ,true,isAvatarPresent()
        );
    }

    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public  void  clickOnSabMenuSpare(){
        actionsWithOurElements.clickOnElement(subMenuSpar);
    }
}


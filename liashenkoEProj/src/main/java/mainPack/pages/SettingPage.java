package mainPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SettingPage extends ParentPage {
    public SettingPage(WebDriver webDriver) {
        super(webDriver); }


    @FindBy(xpath = ".//i[@class = 'fa fa-plus']")
    private WebElement buttonAddSetting;

    @FindBy(xpath = ".//select[@id= 'installation_apparat']")
    private WebElement fildAparat;

    @FindBy(xpath = ".//select[@id= 'installation_apparat']//option[@value = '1']")
    private WebElement brokenSensor;

    public void clickOnButtonAddSetting(){
        actionsWithOurElements.clickOnButton(buttonAddSetting);
    }

    public void clickOnFildAparat() {
    actionsWithOurElements.clickOnButton(fildAparat);
    }

    public void selectAparat() {
        actionsWithOurElements.clickOnButton(brokenSensor);
    }


    public boolean fintElement() {
      return   actionsWithOurElements.isAlementPresent(buttonAddSetting);

    }
}

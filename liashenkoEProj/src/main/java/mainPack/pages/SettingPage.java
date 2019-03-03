package mainPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SettingPage extends ParentPage {
    public SettingPage(WebDriver webDriver) {
        super(webDriver); }


    @FindBy(xpath = ".//a[@href = 'http://v3.test.itpmgroup.com/dictionary/installation/edit']")
    private WebElement buttonAddSetting;

    @FindBy(xpath = ".//*[text()='05.06.2019 00:00']")
    private WebElement newElement;

    public void clickOnButtonAddSetting(){
        actionsWithOurElements.clickOnButton(buttonAddSetting);
    }

    public boolean elementCraeted() {
        return actionsWithOurElements.isAlementPresent(newElement);
    }
    public void selectElement() {
        actionsWithOurElements.clickOnButton(newElement);
    }
}

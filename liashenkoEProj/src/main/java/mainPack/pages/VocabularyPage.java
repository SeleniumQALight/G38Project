package mainPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class VocabularyPage extends ParentPage {
    public VocabularyPage(WebDriver webDriver) {
        super(webDriver); }

    @FindBy(xpath = ".//select[@id= 'installation_apparat']")
    private WebElement fildAparat;

    @FindBy(xpath = ".//select[@id= 'installation_apparat']//option[@value = '1']")
    private WebElement brokenSensor;

    @FindBy(xpath = ".//select[@id = 'installation_worker']")
    private WebElement fildEmployee;

    @FindBy(xpath = ".//select[@id = 'installation_worker']//option[@value = '10']")
    private  WebElement selectEmployee;

    @FindBy(xpath = ".//button[@name = 'add']")
    private WebElement buttonCreat;

    @FindBy(xpath = ".//select[@id = 'installation_installationDate_date_day']")
    private WebElement selectDateDay;

    @FindBy(xpath = ".//select[@id = 'installation_installationDate_date_day']//option[@value = '5']")
    private WebElement dateDey05;

    @FindBy(xpath = ".//select[@id= 'installation_installationDate_date_month']")
    private WebElement fildMonth;

    @FindBy(xpath = ".//select[@id= 'installation_installationDate_date_month']//option[@value='6']")
    private WebElement month06;

    @FindBy(xpath = ".//select[@id= 'installation_installationDate_date_year']")
    private WebElement fildYear;

    @FindBy(xpath = ".//select[@id= 'installation_installationDate_date_year']//option[@value='2019']")
    private WebElement selectYear;

    @FindBy(xpath = ".//form[@name = 'installation']//button[@name='delete']")
    private WebElement buttonDeletesetting;

    public void clickOnFildAparat() {
        actionsWithOurElements.clickOnButton(fildAparat);
    }

    public void selectAparat() {
        actionsWithOurElements.clickOnButton(brokenSensor);
    }

    public void clickOnFildEmployee() {
    actionsWithOurElements.clickOnButton(fildEmployee);
    }

    public void selectEmployee() {
        actionsWithOurElements.clickOnButton(selectEmployee);
    }

    public void clickOnButtonCreat() {
        actionsWithOurElements.clickOnButton(buttonCreat);
    }

    public void selectDate(){
        actionsWithOurElements.clickOnButton(selectDateDay);
        actionsWithOurElements.clickOnButton(dateDey05);
        actionsWithOurElements.clickOnButton(fildMonth);
        actionsWithOurElements.clickOnButton(month06);
        actionsWithOurElements.clickOnButton(fildYear);
        actionsWithOurElements.clickOnButton(selectYear);

    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnButton(buttonDeletesetting);
    }
}

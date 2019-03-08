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

    @FindBy(xpath = ".//select[@id= 'installation_apparat']//option[@value = '809']")
    private WebElement selectElement;

    @FindBy(xpath = ".//select[@id = 'installation_worker']")
    private WebElement fildEmployee;

    @FindBy(xpath = ".//select[@id = 'installation_worker']//option[@value = '350']")
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

    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement buttonAddPart;

    @FindBy(xpath = ".//input[@id='installed_spares_spareCount']")
    private WebElement inputToSpareCount;

    @FindBy(xpath = ".//select[@id = 'installed_spares_installation']")
    private WebElement fildSettingInVocabulary;

    @FindBy(xpath = ".//select[@id = 'installed_spares_installation']//option[@value = '113']")
    private WebElement selectSettingInVocabulary;

    @FindBy(xpath = ".//select[@id = 'installed_spares_spare']")
    private WebElement fildPart;

    @FindBy(xpath = ".//select[@id = 'installed_spares_spare']//option[@value = '1166']")
    private WebElement selectPart2;

    @FindBy(xpath = ".//input[@type = 'checkbox']")
    private WebElement checkBox;

    public void clickOnFildAparat() {
        actionsWithOurElements.clickOnButton(fildAparat);
    }

    public void selectAparat() {
        actionsWithOurElements.clickOnButton(selectElement);
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

    public void clickOnButtonAddPart() {
        actionsWithOurElements.clickOnButton(buttonAddPart);
    }

    public void enterTextToInputSpareCount(String text) {
        actionsWithOurElements.enterTextInToElement(inputToSpareCount, text);
    }

    public void selectSetting() {
    actionsWithOurElements.clickOnButton(fildSettingInVocabulary);
    actionsWithOurElements.clickOnButton(selectSettingInVocabulary);
    }

    public void selectPart() {
        actionsWithOurElements.clickOnButton(fildPart);
        actionsWithOurElements.clickOnButton(selectPart2);
    }

    public void workWithCheckBox(String status) {
        actionsWithOurElements.setStatusToCheckBox(checkBox, status);
    }

}

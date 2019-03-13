package pages;


import libs.ActionWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DictionaryPage extends ParentPage {
    public DictionaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id='dictionary']")
    private WebElement menuDictionary;

    @FindBy(xpath = ".//*[@id='prov_cus']")
    private WebElement menuDictionaryDeals;

    @FindBy(xpath = "//tr[.//td[contains(text(),'MyCode_4649')]]")
    private WebElement myCode;

    @FindBy(xpath = ".//*[@type='checkbox' and @id='prov_cus_proCustIsFl']")
    public WebElement checkBoxPrivatPerson;

    @FindBy(xpath = ".//*[@type='checkbox' and @id='prov_cus_isOurFirm']")
    public WebElement checkBoxIsOurFirm;

    public void menuClickDictionary() {
        menuDictionary.click();
    }

    public void setMenuDictionaryDeals() {
        menuDictionaryDeals.click();
    }

    public void findMyCardWithCheckBoxes() {
        myCode.click();
    }

    public  void setValueInCheckBoxPrivatPerson() {
        actionWithOurElements.setCheckBoxValue(checkBoxPrivatPerson);
    }

    public void setValueInCheckBoxIsOurFirm() {
        actionWithOurElements.setCheckBoxValue(checkBoxIsOurFirm);
    }
}






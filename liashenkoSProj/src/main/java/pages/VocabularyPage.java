package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VocabularyPage extends PerentPage {
    public VocabularyPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//select[@id='deal_dealDate_date_year']//option[@value='2019']")
    private WebElement yearDeal;

    @FindBy(xpath = ".//select[@id='deal_dealType']//option[@value='137']")
  private   WebElement typeDeal;

    @FindBy (xpath = ".//select[@id='deal_customer']//option[@value ='233' and contains(text(),'Sergey')]")
    private WebElement customer;

    @FindBy(xpath = ".//select[@id='deal_dealDate_date_day']//option[@value='3']")
    private  WebElement dayDeal;

    @FindBy(xpath = ".//select[@id='deal_dealDate_date_month']//option[@value='3']")
    private WebElement monthDeal;

    @FindBy(xpath = ".//select[@id='deal_dealDate_time_hour']//option[@value='17']")
    private WebElement hourDeal;

    @FindBy(xpath = ".//select[@id='deal_dealDate_time_minute']//option[@value='17']")
    private WebElement minuteDeal;

    @FindBy(xpath = ".//select[@id='deal_provider']//option[@value='233']")
    private WebElement providerDeal;

    @FindBy(xpath = ".//button[@type='submit' and @class='btn btn-info']")
    private WebElement buttonCreat;

    @FindBy(xpath = ".//td[text()='SergeyLyashenco']")
    private WebElement creatElementDeal;



    public  void selectDate(){
        actionsWithOurElements.clickOnElement(dayDeal);
        actionsWithOurElements.clickOnElement(monthDeal);
        actionsWithOurElements.clickOnElement(yearDeal);
        actionsWithOurElements.clickOnElement(hourDeal);
        actionsWithOurElements.clickOnElement(monthDeal);
    }

    public void clickSelectTypeDeal() {

        actionsWithOurElements.clickOnElement(typeDeal);
    }

    public void clickSelectCustomer() {
        actionsWithOurElements.clickOnElement(customer);
    }


    public void clickSelectProvider() {
        actionsWithOurElements.clickOnElement(providerDeal);
    }


    public void clickSelectButtonCreat() {
        actionsWithOurElements.clickOnElement(buttonCreat);
    }

    public  boolean selectNewElement(){
     return    actionsWithOurElements.isElementPresent(creatElementDeal);

    }
}

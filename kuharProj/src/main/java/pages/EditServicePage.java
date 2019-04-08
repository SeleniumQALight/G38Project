package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditServicePage extends ParentPage {


    @FindBy(id = "service_apparat_serviceChanges")
    private WebElement inputServiceChanges;

    @FindBy(id = "service_apparat_serviceOperations")
    private WebElement inputServiceOperations;

    @FindBy(name = "service_apparat[apparat]")
    private WebElement inputAparat ;

    @FindBy(id = "service_apparat_worker")
    private WebElement inputSotrudnik;


    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(id = "service_apparat_serviceDate_date_day")
    private WebElement dayDD;

    @FindBy (id = "service_apparat_serviceDate_date_month")
    private WebElement monthDD;

    @FindBy (id = "service_apparat_serviceDate_date_year")
    private WebElement yearDD ;

    @FindBy(id = "service_apparat_serviceDate_time_hour")
    private WebElement hoursDD;

    @FindBy(id = "service_apparat_serviceDate_time_minute")
    private WebElement minutesDD;

    @FindBy(id = "service_apparat_apparat")
    private WebElement apparatDD;

    @FindBy (id = "service_apparat_worker")
    private WebElement sotrudnikDD;

    @FindBy(name = "delete")
    private WebElement buttonDelete;


    public EditServicePage(WebDriver webDriver) {
        super(webDriver);
    }



    public void addServiceChangesIntoInput(String serviceChangesValue){
        actionsWithOurElements.enterTextIntoElement(inputServiceChanges, serviceChangesValue);
    }

    public void addServiceOperationsIntoInput(String serviceOperationsValue){
        actionsWithOurElements.enterTextIntoElement(inputServiceOperations, serviceOperationsValue);
    }



    // dropdown
    public void selectServiceDateDAY(String day){
        actionsWithOurElements.selectTextInDropdown(dayDD, "28");
    }
    public void selectServiceDateMONTH(String month){
        actionsWithOurElements.selectTextInDropdown(monthDD, "нояб.");
    }
    public void selectServiceDateYEAR(String year){
        actionsWithOurElements.selectTextInDropdown(yearDD, "2024");
    }
    public void selectServiceDateHOURS(String hours){
        actionsWithOurElements.selectTextInDropdown(hoursDD, "23");
    }
    public void selectServiceDateMINUTES(String minutes){
        actionsWithOurElements.selectTextInDropdown(minutesDD, "23");
    }


    public void addAparatIntoDD(String aparatValue){
        actionsWithOurElements.selectTextInDropdown(apparatDD, aparatValue);
    }

    public void addSotrudnikIntoDD(String sotrudnikValue){
        actionsWithOurElements.selectTextInDropdown(sotrudnikDD, sotrudnikValue);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }


}

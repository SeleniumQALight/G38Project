package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProvidersPage extends ParentPage {

    public ProvidersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//table[@id='device_list']/tbody/tr[1]")
    private WebElement firsProvidersInList;


    public void openFirstProvidersInList() {
        actionsWithOurElements.clickOnElement(firsProvidersInList);
    }
}
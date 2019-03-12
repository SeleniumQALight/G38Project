package pages.dictionary.providersPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.ParentPage;


public class ProvidersPage extends ParentPage {

    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement addButton;

    @FindBy(xpath = ".//table[@id='device_list']/tbody/tr[1]")
    private WebElement firsProvidersInList;


    public ProvidersPage(WebDriver driver) {
        super(driver);
    }


    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }

    public void openFirstProvidersInList() {
        actionsWithOurElements.clickOnElement(firsProvidersInList);
    }
}
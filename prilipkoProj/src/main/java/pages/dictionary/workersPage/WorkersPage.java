package pages.dictionary.workersPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.ParentPage;


public class WorkersPage extends ParentPage {

    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement addButton;


    public WorkersPage(WebDriver driver) {
        super(driver);
    }


    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }
}
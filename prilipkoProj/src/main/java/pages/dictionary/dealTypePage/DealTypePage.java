package pages.dictionary.dealTypePage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.ParentPage;


public class DealTypePage extends ParentPage {

    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement addButton;


    public DealTypePage(WebDriver driver) {
        super(driver);
    }


    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }
}

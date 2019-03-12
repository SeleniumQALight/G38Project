package pages.dictionary.dealTypePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class DealTypeEditPage extends ParentPage {

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement createButton;


    public DealTypeEditPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnCreateButton() {
        actionsWithOurElements.clickOnElement(createButton);
    }
}

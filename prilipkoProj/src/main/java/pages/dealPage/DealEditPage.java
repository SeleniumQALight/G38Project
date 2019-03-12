package pages.dealPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class DealEditPage extends ParentPage {

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement createButton;


    public DealEditPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnCreateButton() {
        actionsWithOurElements.clickOnElement(createButton);
    }
}

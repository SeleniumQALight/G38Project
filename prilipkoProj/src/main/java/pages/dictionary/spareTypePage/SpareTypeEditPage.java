package pages.dictionary.spareTypePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class SpareTypeEditPage extends ParentPage {

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement createButton;


    public SpareTypeEditPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnCreateButton() {
        actionsWithOurElements.clickOnElement(createButton);
    }
}

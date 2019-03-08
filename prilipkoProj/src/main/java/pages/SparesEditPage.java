package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SparesEditPage extends ParentPage {

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement deleteButton;

    public SparesEditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@id='spares_spareName']")
    private WebElement spareNameField;

    @FindBy(xpath = ".//select[@id='spares_spareType']")
    private WebElement sparesSelect;


    public void inputSpareName(String spareName) {
        actionsWithOurElements.enterTextInToElement(spareNameField, spareName);
    }

    public void selectSparesType(String spareType) {
        actionsWithOurElements.selectVisibleTextInDropdown(sparesSelect, spareType);
    }

    public void clickDeleteButton() {
        actionsWithOurElements.clickOnElement(deleteButton);
    }
}
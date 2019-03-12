package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpareEditPage extends ParentPage{


    @FindBy (name = "add")
    private WebElement addButton;

    @FindBy (id = "spares_spareName")
    private WebElement inputSpareName;


    @FindBy (id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy (name = "delete")
    private WebElement deleteButton;

    public SpareEditPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(addButton);
    }

    public void enterSpareNameIntoInput(String spareName) {
        actionsWithOurElements.enterTextInToElement(inputSpareName, spareName);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithOurElements.selectTextInDropdown(spareTypeDD, spareType);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(deleteButton);
    }
}

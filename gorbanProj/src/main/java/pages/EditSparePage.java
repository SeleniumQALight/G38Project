package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(name = "add")
    private WebElement buttonAdd;

    @FindBy(id = "spares_spareName")
    private WebElement inputSpareNameField;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithOurElements.selectTextInDropdown(spareTypeDD, spareType);
    }

    public void enterSpareNameInToInput(String spareName) {
        actionsWithOurElements.enterTextIntoElement(inputSpareNameField, spareName);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

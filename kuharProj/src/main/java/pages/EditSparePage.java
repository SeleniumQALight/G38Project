package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {


    @FindBy(id = "spares_spareName")
    private WebElement inputSpareNameField;


    @FindBy(className = "btn btn-info")
    private WebElement buttonCreate;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDropDown;

    @FindBy(name = "delete")
    private WebElement buttonDelete;




    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void enterSpareNameIntoInput(String spareName) {
        actionsWithOurElements.enterTextIntoElement(inputSpareNameField,spareName);
    }

    public void selectSpareTypeInDropDown(String spareType) {
        actionsWithOurElements.selectTextInDropdown(spareTypeDropDown, spareType);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }


    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {

    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickButtonCreate() {
        actionsWithElements.clickOnElement(buttonCreate);
    }

    public void enterSpareNameInToInput(String spareName) {
        actionsWithElements.enterTextInToElement(inputSpareName, spareName);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithElements.selectTextInDropDown(spareTypeDD, spareType);
    }

    public void clickButtonDelete() {
        actionsWithElements.clickOnElement(buttonDelete);
    }
}

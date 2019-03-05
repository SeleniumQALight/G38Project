package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePAge extends ParentPage {

    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;

    @FindBy(name = "add")
    private WebElement createButton;

    @FindBy(name = "spares_spareType")
    private WebElement spareTypeDropDown;

    @FindBy (name = "delete")
    private WebElement deleteButton;

    public EditSparePAge(WebDriver webDriver) {
        super(webDriver);
    }


    public void enterSpareNameInToInput(String spareName) {
        actionWithOurElements.enterTextInToElement(inputSpareName, spareName);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionWithOurElements.selectTextInDropDown(spareTypeDropDown, spareType);

    }

    public void clickOnButtonCreate() {
        actionWithOurElements.clickOnElement(createButton);
    }

    public void clickOnButtonDelete() {
        actionWithOurElements.clickOnElement(deleteButton);

    }
}

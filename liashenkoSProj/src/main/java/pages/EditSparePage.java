package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends PerentPage {
    @FindBy (id="spares_spareName")
    private WebElement inputSparName;
    @FindBy(name="add")
private WebElement buttonAdd;
    @FindBy (id="spares_spareType")
    private WebElement spareTypeDD;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void enterSparenNameInToInput(String spareName) {
        actionsWithOurElements.enterTextInToElement(inputSparName, spareName);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void selectSparTypeInDD(String spareType) {
        actionsWithOurElements.slectTextInDD(spareTypeDD,spareType);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

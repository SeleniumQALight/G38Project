package pages;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {
    @FindBy (name = "add" )
    private WebElement buttonAdd;
    @FindBy (id ="spares_spareName")
    private WebElement inputSpareName;
    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;
    @FindBy (name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void enterSpareNameInToInput(String spareName) {
        actionsWithOurElements.enterTextInToElement(inputSpareName, spareName);
    }

    public void selectSpareTypeInDD(String spareType) {
        actionsWithOurElements.selectTextInDD(spareTypeDD, spareType);

    }

    public void clickOnButtonCrete() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void clickOnDelite() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

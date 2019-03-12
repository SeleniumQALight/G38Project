package pages.dictionary.providersPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;


public class ProvidersEditPage extends ParentPage {

    public ProvidersEditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//label[text()='Private person']/input")
    private WebElement privatePersonCheckbox;

    @FindBy(xpath = ".//label[text()='Is our firm']/input")
    private WebElement isOurFirmCheckbox;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement createButton;


    public void privatPersonCheckbox(String status) {
        actionsWithOurElements.setStatusToCheckbox(privatePersonCheckbox,status);
    }

    public void isOurFirmCheckbox(String status) {
        actionsWithOurElements.setStatusToCheckbox(isOurFirmCheckbox,status);
    }

    public void clickOnCreateButton() {
        actionsWithOurElements.clickOnElement(createButton);
    }
}
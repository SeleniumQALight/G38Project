package pages;


import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ParentPage {

    WebDriver driver;

    protected ActionsWithOurElements actionsWithOurElements;

    Logger logger = Logger.getLogger(getClass());

    public ParentPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver,this); // Создали объекты WebElement

        actionsWithOurElements = new ActionsWithOurElements(driver);
    }

    @FindBy(xpath = ".//li[@id='dictionary']")
    private WebElement dictionaryButton;

    @FindBy(xpath = ".//li[@id='apparat']")
    private WebElement apparatButton;

    @FindBy(xpath = ".//li[@id='workers']")
    private WebElement workersButton;

    @FindBy(xpath = "//li[@id='prov_cus']")
    private WebElement providersButton;

    @FindBy(xpath = ".//li[@id='installation']")
    private WebElement installationButton;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement addButton;


    public void clickOnDictionaryButton() {
        actionsWithOurElements.clickOnElement(dictionaryButton);
    }

    public void clickOnApparatButton() {
        actionsWithOurElements.clickOnElement(apparatButton);
    }

    public void clickOnWorkersButton() {
        actionsWithOurElements.clickOnElement(workersButton);
    }

    public void clickProvidersButton() {
        actionsWithOurElements.clickOnElement(providersButton);
    }

    public void clickOnInstallationButton() {
        actionsWithOurElements.clickOnElement(installationButton);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }
}
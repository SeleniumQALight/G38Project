package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WorkersEditPage extends ParentPage {

    public WorkersEditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@id='workers_workerSurname']")
    private WebElement workerSurnameField;

    @FindBy(xpath = ".//input[@id='workers_workerName']")
    private WebElement workerNameField;

    @FindBy(xpath = ".//input[@id='workers_workerMiddleName']")
    private WebElement workerMiddleNameField;

    @FindBy(xpath = ".//input[@id='workers_workerPhone']")
    private WebElement workerPhoneField;


    public void inputWorkerSurname(String surname) {
        actionsWithOurElements.enterTextInToElement(workerSurnameField, surname);
    }

    public void inputWorkerName(String name) {
        actionsWithOurElements.enterTextInToElement(workerNameField, name);
    }

    public void inputWorkerMiddleName(String middleName) {
        actionsWithOurElements.enterTextInToElement(workerMiddleNameField, middleName);
    }

    public void inputWorkerPhone(String phone) {
        actionsWithOurElements.enterTextInToElement(workerPhoneField, phone);
    }
}
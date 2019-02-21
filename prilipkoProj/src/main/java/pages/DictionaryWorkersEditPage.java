package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DictionaryWorkersEditPage {

    private WebDriver driver;

    public DictionaryWorkersEditPage(WebDriver driver) {
        this.driver = driver;
    }


    By workerSurnameField = By.xpath(".//input[@id='workers_workerSurname']");
    By workerNameField = By.xpath(".//input[@id='workers_workerName']");
    By workerMiddleNameField = By.xpath(".//input[@id='workers_workerMiddleName']");
    By workerPhoneField = By.xpath(".//input[@id='workers_workerPhone']");
    By createButton = By.xpath(".//button[@type='submit']");


    public void inputWorkerSurname(String surname) {
        driver.findElement(workerSurnameField).sendKeys(surname);
    }

    public void inputWorkerName(String name) {
        driver.findElement(workerNameField).sendKeys(name);
    }

    public void inputWorkerMiddleName(String middleName) {
        driver.findElement(workerMiddleNameField).sendKeys(middleName);
    }

    public void inputWorkerPhone(String phoneNumber) {
        driver.findElement(workerPhoneField).sendKeys(phoneNumber);
    }

    public DictionaryWorkersPage clickCreateButton() {
        driver.findElement(createButton).click();
        return new DictionaryWorkersPage(driver);
    }
}
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
}
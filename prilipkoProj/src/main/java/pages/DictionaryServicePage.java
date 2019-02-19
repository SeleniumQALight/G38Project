package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DictionaryServicePage {

    private WebDriver driver;

    public DictionaryServicePage(WebDriver driver) {
        this.driver = driver;
    }

    private By addButton = By.xpath(".//a[@class='btn btn-info btn-sm']");

    public DictionaryWorkersEditPage clickAddButton() {
        driver.findElement(addButton).click();
        return new DictionaryWorkersEditPage(driver);
    }
}
package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DictionaryApparatPage {

    private WebDriver driver;

    public DictionaryApparatPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addButton = By.xpath(".//a[@class='btn btn-info btn-sm']");

    public DictionaryApparatEditPage clickAddButton() {
        driver.findElement(addButton).click();
        return new DictionaryApparatEditPage(driver);
    }
}
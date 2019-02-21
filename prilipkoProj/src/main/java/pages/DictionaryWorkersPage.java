package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DictionaryWorkersPage {

    private WebDriver driver;

    public DictionaryWorkersPage(WebDriver driver) {
        this.driver = driver;
    }


    private By workersHeadlineText = By.xpath(".//h3");
    private By addButton = By.xpath(".//a[@class='btn btn-info btn-sm']");
    private By workersInfoList = By.xpath(".//table[@id='device_list']//td");


    public void assertText(String text) {
        String headlineText = driver.findElement(workersHeadlineText).getText();
        Assert.assertEquals(text, headlineText);
    }

    public DictionaryWorkersEditPage clickAddButton() {
        driver.findElement(addButton).click();
        return new DictionaryWorkersEditPage(driver);
    }
}
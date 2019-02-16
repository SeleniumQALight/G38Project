package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DictionaryApparatEditPage {

    private WebDriver driver;

    public DictionaryApparatEditPage(WebDriver driver) {
        this.driver = driver;
    }

    By apparatNumberField = By.xpath(".//input[@id='apparat_apparatNumber']");
    By apparatCommentField = By.xpath(".//input[@id='apparat_apparatComment']");
    By createButton = By.xpath(".//button[@type='submit']");
}
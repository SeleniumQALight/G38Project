package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath(".//input[@placeholder='Email']");
    private By passwordField = By.xpath(".//input[@type='password']");
    private By submitButton = By.xpath(".//button[@type='submit']");

    public void inputLogin(String login) {
        driver.findElement(emailField).sendKeys(login);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}
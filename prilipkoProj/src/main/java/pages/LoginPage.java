package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends ParentPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private By emailField = By.xpath(".//input[@placeholder='Email']");
    private By passwordField = By.xpath(".//input[@type='password']");
    private By submitButton = By.xpath(".//button[@type='submit']");


    public void openPage() {
        try {
            driver.get("http://v3.test.itpmgroup.com/login");
            System.out.println("Login page was opened");
        } catch (Exception e) {
            System.out.println("Cannot open login page" + e);
            Assert.fail("Cannot open login page" + e);
        }
    }

    public void enterTextInToInputLogin(String login) {
        try {
            driver.findElement(emailField).clear();
            driver.findElement(emailField).sendKeys(login);
            System.out.println(login + " was input");
        } catch (Exception e) {
            System.out.println("Can not work with element");
            Assert.fail("Can not work with element " + e);
        }

    }

    public void enterTextInToInputPassword(String password) {
        try {
            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys(password);
            System.out.println(password + " was input");
        } catch (Exception e) {
            System.out.println("Can not work with element");
            Assert.fail("Can not work with element " + e);
        }
    }

    public void clickOnSubmitButton() {
        try {
            driver.findElement(submitButton).click();
            System.out.println("Button Submit was clicked");
        } catch (Exception e) {
            System.out.println("Can not work with element");
            Assert.fail("Can not work with element " + e);
        }
    }
}
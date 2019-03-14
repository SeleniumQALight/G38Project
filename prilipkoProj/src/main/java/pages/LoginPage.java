package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends ParentPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement submitButton;


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
        actionsWithOurElements.enterTextInToElement(emailField,login);
    }

    public void enterTextInToInputPassword(String password) {
        actionsWithOurElements.enterTextInToElement(passwordField,password);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);
    }
}
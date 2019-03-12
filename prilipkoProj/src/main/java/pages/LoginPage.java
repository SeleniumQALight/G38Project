package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//div[@class='login-logo']//b")
    private WebElement mainHeadline;

    @FindBy(xpath = ".//input[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver);
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

    public void login(String login, String password) {
        openPage();
        enterTextInToInputLogin(login);
        enterTextInToInputPassword(password);
        clickOnSubmitButton();
    }
}
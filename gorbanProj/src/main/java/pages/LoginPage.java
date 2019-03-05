package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement button;

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            System.out.println("Login page was opened");
        } catch (Exception e) {
            System.out.println("Can not open Login page" + e);
            Assert.fail("Can not open Login page" + e);
        }
    }

    public void enterTextInToInputLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterTextInToInputPass(String pass) {
        actionsWithOurElements.enterTextInToElement(inputPass, pass);
    }

    public void clickOnButtonSubmit() {
        actionsWithOurElements.clickOnElement(button);
    }
}
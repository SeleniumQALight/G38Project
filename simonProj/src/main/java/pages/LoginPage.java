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
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement button;


    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was open");
        } catch (Exception e) {
           logger.info("Can not open login page" + e);
            Assert.fail("Can not open login page" + e);
        }

    }

    public void enterTextInToInputLogin(String login) {
        actionWithOurElements.enterTextInToElement(inputLogin, login);

    }


    public void enterTextInToInputPass(String pass) {
        actionWithOurElements.enterTextInToElement(inputPassword, pass);
    }

    public void clickOnButtonSubmit() {
        actionWithOurElements.clickOnElement(button);
    }
}

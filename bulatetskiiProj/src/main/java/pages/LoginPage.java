package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy (name = "_username")
    private WebElement inputLogin;

    @FindBy (id = "password")
    private WebElement inputPass;

    @FindBy (tagName = "button")
    private  WebElement button;

    @Step
    public void openPage() {
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e){
            logger.info("Can not open Login page " + e); // for logger
            Assert.fail("Can not open Login page " + e); // for report
        }
    }

    @Step
    public void enterTextInToInputLogin(String login) {

         actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    @Step
    public void enterTextInToInputPass(String pass) {
         actionsWithOurElements.enterTextInToElement(inputPass, pass);
    }

    @Step
    public void clickOnButtonSubmit (){
         actionsWithOurElements.clickOnElement (button);
    }

    @Step
    public void login(String login, String password) {
        openPage();
        enterTextInToInputLogin(login);
        enterTextInToInputPass(password);
        clickOnButtonSubmit();

    }
}

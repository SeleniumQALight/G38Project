package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.PasswordAuthentication;
import java.util.logging.Logger;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (name = "_username")
    private WebElement inputLogin;

    @FindBy(id="password")
    private WebElement inputPass;

    @FindBy (tagName = "button")
    private WebElement button;

    @Step
    public void enterTextInToinputLogin(String Login) {
//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(Login);
//            System.out.println(Login+"was input");
//        } catch (Exception e){
//            System.out.println("Can not work with element");
//            Assert.fail("Can not work with element");
//        }
        actionsWithOurElements.enterTextInToElement(inputLogin, Login);

    }
    @Step
    public  void enterTextInToinputPass(String Pass) {
//        try {
//            inputPass.clear();
//            inputLogin.sendKeys(Pass);
//            System.out.println(Pass + "was input");
//        } catch (Exception e) {
//            System.out.println("Can not work with element");
//            Assert.fail("Can not work with element");
//        }
        actionsWithOurElements.enterTextInToElement(inputPass, Pass);

    }
    @Step
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info ("Login page was opened");
        }catch (Exception e){
            logger.error("Cannot open login page" + e);
            Assert.fail ("Can not open page");

        }

    }
    @Step
    public void clickOnButtonSubmit (){
//        try {
//            button.click();
//            System.out.println("Button submit was clicked");
//        }
//            catch(Exception e){
//                System.out.println("Can not work with element");
//                Assert.fail("Can not work with element");
//            }
//
        actionsWithOurElements.clickOnElement (button);
       }

    public void login(String login, String password) {
        openPage();
        enterTextInToinputLogin(login);
        enterTextInToinputPass(password);
        clickOnButtonSubmit();
    }
}


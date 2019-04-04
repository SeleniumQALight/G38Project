package pages;

import io.qameta.allure.Step;
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

    @Step
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open login page " + e);
            Assert.fail("Can not open login page " + e);
        }
    }

    @Step
    public void enterTextInToInputLogin(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);

//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            System.out.println(login + " was inputted ");
//        } catch (Exception e) {
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element" + e);
//        }
    }

    @Step
    public void enterTextInToInputPass(String pass) {
        actionsWithOurElements.enterTextInToElement(inputPass, pass);
//        try {
//            inputPass.clear();
//            inputPass.sendKeys(pass);
//            System.out.println(pass + " was inputted ");
//        } catch (Exception e) {
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element" + e);
//        }
    }

    @Step
    public void clickOnButtonSubmit() {
        actionsWithOurElements.clickOnElement(button);
//        try {
//            button.click();
//            System.out.println("Button Submit was clicked");
//        } catch (Exception e) {
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element" + e);
//        }
    }

    @Step
    public void login(String login, String passWord) {
        openPage();
        enterTextInToInputLogin(login);
        enterTextInToInputPass(passWord);
        clickOnButtonSubmit();
    }
}

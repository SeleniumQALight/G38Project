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

    @FindBy(name = "_username")// id/path
    private WebElement inputLogin;   // обьявление веб-елемента

    @FindBy(id = "password") // id/path
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement button;

    @Step
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
//            System.out.println("Login page was opened");
            logger.info("Login page was open");
        } catch (Exception e) {
//            System.out.println("Can not open Login page" + e);
            logger.info("Can not open Login page " + e);
            Assert.fail("Can not open Login page" + e);
        }
    }

    @Step
    public void enterTextInToInputLogin(String login) {
//         try {
//             inputLogin.clear();
//             inputLogin.sendKeys(login);
//             System.out.println(login + " was inputted");
//         }catch (Exception e){
//             System.out.println("Cant work with ellement" + e);
//             Assert.fail("Cant work with ellement + e");
//         }
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }
    @Step
    public void enterTextInToInputPass(String pass) {
//        try {
//            inputPass.clear();
//            inputPass.sendKeys(pass);
//            System.out.println(pass + " was inputted");
//        }catch (Exception e){
//            System.out.println("Cant work with ellement" + e);
//            Assert.fail("Cant work with ellement + e");
//        }
        actionsWithOurElements.enterTextIntoElement(inputPass, pass);
    }
    @Step
    public void clickOnButtonSubmit() {
//         try {
//             button.click();
//             System.out.println("Button was clicked");
//
//         }catch (Exception e){
//             System.out.println("Cant work with ellement" + e);
//             Assert.fail("Cant work with ellement + e");
//         }
        actionsWithOurElements.clickOnElement(button);
    }

    @Step
    public void login(String invalidLogin, String password) {
        openPage();
        enterTextInToInputLogin(invalidLogin);
        enterTextInToInputPass(password);
        clickOnButtonSubmit();
    }

}
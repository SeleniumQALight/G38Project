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

    @FindBy (name = "_username")
    private WebElement inputLogin;

    @FindBy (id = "password")
    private WebElement inputPass;

    @FindBy (tagName = "button")
    private WebElement button;

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was open");
        } catch (Exception e) {
            logger.error("Can not open login page" + e);
            Assert.fail("Can not open login page");
        }
    }

    public void enterTextInToInputLogin(String login) {
//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            System.out.println(login + " was inputted ");
//        } catch (Exception e) {
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element");
//        }//вместо всего этого одна строка снизу
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);
    }
    public void enterTextInToInputPass (String pass) {
//        try {
//            inputPass.clear();
//            inputPass.sendKeys(pass);
//            System.out.println(pass + " was inputted ");
//        } catch (Exception e) {
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element");
//        }
        actionsWithOurElements.enterTextIntoElement(inputPass, pass);
    }
    public void clickOnButtonSubmit () {
//        try {
//            button.click();
//            System.out.println("Button Submit was clicked ");
//        } catch (Exception e) {
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element");
//        }
        actionsWithOurElements.clickOnElement (button);
    }

    public void login(String login, String passWord) {
        openPage();
        enterTextInToInputLogin(login);
        enterTextInToInputPass(passWord);
        clickOnButtonSubmit();
    }
}

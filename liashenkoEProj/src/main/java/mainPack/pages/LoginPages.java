package mainPack.pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages extends ParentPage {
    public LoginPages(WebDriver webDriver) {
        super(webDriver); }

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement button;


    public void openPages() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e){
            logger.error("Can not Login Page" + e);
            Assert.fail("Can not Login Page" + e);
        }
    }

    public void enterTextInToInputLogin(String login){
        actionsWithOurElements.enterTextInToElement(inputLogin,login);

        }

    public void enterTextInToInputPass(String pass){
        actionsWithOurElements.enterTextInToElement(inputPass, pass);
    }

    public void clickOnButtonSubmit(){
        actionsWithOurElements.clickOnButton(button);
        }

    public void login(String login, String password) {
        openPages();
        enterTextInToInputPass(password);
        enterTextInToInputLogin(login);
        clickOnButtonSubmit();
    }
}



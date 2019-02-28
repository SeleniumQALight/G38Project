package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username") // id/path
    private WebElement inputLogin;      // обьявление веб-елемента

    @FindBy(id = "password") // id/path
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement button;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {

        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
            System.out.println("Login page was open");
        } catch (Exception e) {
            System.out.println("Can not open Login page " + e);
            Assert.fail("Can not open Login page " + e);
        }

    }

    public void enterTextIntoInputLogin(String login) {
//         try {
//             inputLogin.clear();
//             inputLogin.sendKeys(login);
//             System.out.println(login + " was inputted");
//         }catch (Exception e){
//             System.out.println("Cant work with ellement" + e);
//             Assert.fail("Cant work with ellement + e");
//         }
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);   // заменили вместо try
    }

    public void enterTextIntoInputPass(String pass) {
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


}

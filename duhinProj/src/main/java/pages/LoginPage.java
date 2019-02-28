package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.PasswordAuthentication;

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
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            System.out.println("Login page was opened");
        }catch (Exception e){
            System.out.println("Cannot open login page" + e);
            Assert.fail ("Can not open page");

        }

    }
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
    }


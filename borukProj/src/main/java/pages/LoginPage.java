package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(name = "_username")
    private WebElement inputLogin; // object should create after new

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement button;

    public void openPage() {
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            System.out.println("Login page was opened");
        } catch (Exception e){
            System.out.println("Can not open Login page " + e); // for logger
            Assert.fail("Can not open Login page " + e); // for report
        }
    }

    public void enterTextInToInputLogin(String login) {
//        try{
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            System.out.println("Login was input");
//        }catch (Exception e){
//            System.out.println("Can not work with element " +e);
//            Assert.fail("Can not open Login page " + e);
//        }

        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterTextInToInputPass(String pass) {
//        try{
//            inputPass.clear();
//            inputPass.sendKeys(pass);
//            System.out.println("Password was input");
//        }catch (Exception e){
//            System.out.println("Can not work with element " +e);
//            Assert.fail("Can not open Login page " + e);
//        }
        actionsWithOurElements.enterTextInToElement(inputPass, pass);
    }
    public void clickOnButtonSubmit (){
        try{
            button.click();
            System.out.println("Button Submit was clicked");
        }catch (Exception e){
            System.out.println("Can not work with element " +e);
            Assert.fail("Can not open Login page " + e);
        }
    }
    public void clickOnElement (){
        actionsWithOurElements.clickOnElement(button);

    }
}

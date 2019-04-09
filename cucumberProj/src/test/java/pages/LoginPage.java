package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement buttonVhod;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com/");
            System.out.println("Login page was opened");
        } catch (Exception e){
            System.out.println("Error : can not open page");
            Assert.fail("Error : can not open page");
        }
    }


    public void enterTextInToInputLogin(String login) {
        try {
            inputLogin.clear();
            inputLogin.sendKeys(login);
            System.out.println(login + " was inputted in to login input");

        }catch (Exception e){
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }

    }

    public void enterTextInToInputPass(String pass) {
        try{
           inputPassword.clear();
           inputPassword.sendKeys(pass);
            System.out.println(pass + " was inputted into pass input");

        }catch (Exception e){
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }

    public void clickOnButtonVhod(){
        try{
            buttonVhod.click();
            System.out.println("Button was clicked");
        }catch (Exception e){
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }


}

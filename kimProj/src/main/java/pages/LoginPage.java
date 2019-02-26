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

    @FindBy(name = "_username") // поиск
    private WebElement inputLogin; //объявление веб элемента

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement button;

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            System.out.println("Login page was opened");
        }  catch (Exception e) {
            System.out.println("Can not open login page" + e);
            Assert.fail("Can not open login page" + e);
        }
    }

    public void enterTextInToInputLogin(String login) {

//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            System.out.println(login + " was input ");
//        } catch (Exception e){
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element");
//        }
    }

    public void enterTextInToPassword(String password) {
        try {
            inputPass.clear();
            inputPass.sendKeys(password);
            System.out.println(password + " was inputed");
        } catch(Exception e) {
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element");
        }
    }

    public void clickOnButtonSubmit() {
        try {
            button.click();
            System.out.println("Button Submit was clicked");
        } catch(Exception e) {
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element");
        }
    }
}

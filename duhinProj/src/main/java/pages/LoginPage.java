package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.PasswordAuthentication;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterTextInToinputLogin(String Login) {
        try {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(Login);
            System.out.println(Login+"was input");
        } catch (Exception e){
            System.out.println("Can not work with element");
            Assert.fail("Can not work with element");
        }

    }

    public  void enterTextInToinputPass(String Pass) {
        try {
            webDriver.findElement(By.id("password")).clear();
            webDriver.findElement(By.id("password")).sendKeys(Pass);
            System.out.println(Pass + "was input");
        } catch (Exception e) {
            System.out.println("Can not work with element");
            Assert.fail("Can not work with element");
        }

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
        try {
            webDriver.findElement(By.tagName("button")).click();
            System.out.println("Button submit was clicked");
        }
            catch(Exception e){
                System.out.println("Can not work with element");
                Assert.fail("Can not work with element");
            }

        }
    }


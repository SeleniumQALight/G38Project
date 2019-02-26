package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            System.out.println("Login page was opened");
        } catch (Exception e) {
            System.out.println("Can not open login page " + e);
            Assert.fail("Can not open login page " + e);
        }
    }

    public void enterTextInToInputLogin(String login) {
        try {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            System.out.println(login + " was inputted ");
        } catch (Exception e) {
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }

    public void enterTextInToInputPass(String pass) {
        try {
            webDriver.findElement(By.id("password")).clear();
            webDriver.findElement(By.id("password")).sendKeys(pass);
            System.out.println(pass + " was inputted ");
        } catch (Exception e) {
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }

    public void clickOnButtonSubmit() {
        try {
            webDriver.findElement(By.tagName("button")).click();
            System.out.println("Button Submit was clicked");
        } catch (Exception e) {
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }
}

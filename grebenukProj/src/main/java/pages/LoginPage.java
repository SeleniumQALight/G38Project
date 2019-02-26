package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //1. Добавляем наследование и альт+ентер и автоматом создается конструктор

public class LoginPage extends ParentPage {// 1.1. СОздался конструктор
    public LoginPage(WebDriver webDriver) { // 1.1. СОздался конструктор
        super(webDriver);  // 1.1. СОздался конструктор
    }

    public void openPage() { // 2. openPage created with alt Delete
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            System.out.println("Login page was opened");
        } catch (Exception e) {
            System.out.println("Can not open login page + " + e); // it's going to out program
            Assert.fail("Can not open login page + " + e); // it's going to test otchot
        }

    }

    public void enterTextIntoInputLogin(String login) {
        try {
            webDriver.findElement(By.name("_username")).clear(); // we cleaned the field for login
            webDriver.findElement(By.name("_username")).sendKeys(login);
            System.out.println(login + "was input");
        } catch (Exception e) {
            System.out.println("Can not input login");
            Assert.fail("Can not input login" + e);
        }
    }

    public void enterTextIntoInputPassword (String password) {
        try {
            webDriver.findElement(By.id("password")).clear(); // we cleaned the field for login
            webDriver.findElement(By.id("password")).sendKeys(password);
            System.out.println(password + "was input");
        } catch (Exception e) {
            System.out.println("Can not input password");
            Assert.fail("Can not input password" + e);
        }

    }

    public void clickOnEnterButton () {

        try {
            webDriver.findElement(By.tagName("button")).click();
            System.out.println("Button Submit was clicked");
        } catch (Exception e) {
            System.out.println("Can not input some data");
            Assert.fail("Can not input some data" + e);
        }
    }
}

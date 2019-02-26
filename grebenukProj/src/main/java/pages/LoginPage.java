package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //1. Добавляем наследование и альт+ентер и автоматом создается конструктор
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {// 1.1. СОздался конструктор
    public LoginPage(WebDriver webDriver) { // 1.1. СОздался конструктор
        super(webDriver);  // 1.1. СОздался конструктор
    }

    @FindBy (name= "_username")
    private WebElement inputLogin;

    @FindBy (id= "password")
    private WebElement inputPass;

    @FindBy(tagName= "button")
    private WebElement button;

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
        actionsWithOurElements.enterTextIntoElement(inputLogin, login);

    }
 /*       try {
            inputLogin.clear(); // we cleaned the field for login
            inputLogin.findElement(By.name("_username")).sendKeys(login);
            System.out.println(login + "was input");
        } catch (Exception e) {
            System.out.println("Can not input login");
            Assert.fail("Can not input login" + e);
        }
    }
 /*

  */
    public void enterTextIntoInputPassword (String password) {
        actionsWithOurElements.enterTextIntoElement(inputPass, password);
    }
/*        try {
            inputPass.clear(); // we cleaned the field for login
            inputPass.sendKeys(password);
            System.out.println(password + "was input");
        } catch (Exception e) {
            System.out.println("Can not input password");
            Assert.fail("Can not input password" + e);
        }

    }
*/
    public void clickOnEnterButton () {
        actionsWithOurElements.enterTextIntoElement(button);
/*
        try {
            button.click();
            System.out.println("Button Submit was clicked");
        } catch (Exception e) {
            System.out.println("Can not input some data");
            Assert.fail("Can not input some data" + e);
        }

        */
    }
}

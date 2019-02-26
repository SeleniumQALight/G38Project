package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPswd;

    @FindBy(tagName = "button")
    private WebElement button;



    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            System.out.println("Login page was opened");
        }catch (Exception e){
            System.out.println("Can not open Login Page " + e);
            Assert.fail("Can not open Login Page " + e);
        }
    }

    public void enterTextInToInputLogin(String login) {

        actionsWithOurElements.enterTextInToElement(inputLogin, login);
//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            System.out.println(login + " was inputted ");
//
//        }catch (Exception e){
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element" + e);
//        }
    }

    public void enterTextInToInputPass(String pass) {

        actionsWithOurElements.enterTextInToElement(inputPswd, pass);

//        try {
//            inputPswd.clear();
//            inputPswd.sendKeys(pass);
//            System.out.println(pass + " was inputted ");
//
//        }catch (Exception e){
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element" + e);
//        }
    }

    public void clickOnButtonSubmit(){
        actionsWithOurElements.clickOnElement(button);
//        try{
//            button.click();
//            System.out.println("Button Submit was clicked");
//        }catch (Exception e){
//            System.out.println("Can not work with element" + e);
//            Assert.fail("Can not work with element" + e);
//        }
    }
}

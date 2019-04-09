package StepDefinitions;

import Selenium.SeleniumFunctions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class V3Login_StepDefinition {
    LoginPage loginPage = new LoginPage(SeleniumFunctions.driver);

    @Given("^user opens Login Page$")
    public void user_opens_Login_Page() throws Throwable {
        loginPage.openPage();
    }

    @When("^user enters login \"(.*?)\" in input login on Login Page$")
    public void user_enters_login_in_input_login_on_Login_Page(String login) throws Throwable {
        loginPage.enterTextInToInputLogin(login);
    }
    @When("^user enters pass \"(.*?)\" in input pass on Login Page$")
    public void user_enters_pass_in_input_pass_on_Login_Page(String pass) throws Throwable {
        loginPage.enterTextInToInputPass(pass);
    }

    @When("^user clicks on Sign in button on Login Page$")
    public void user_clicks_on_Sign_in_button_on_Login_Page() throws Throwable {
        loginPage.clickOnButtonVhod();
    }



}

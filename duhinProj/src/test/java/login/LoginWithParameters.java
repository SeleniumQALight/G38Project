package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.ParentPage;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithParameters extends ParentTest {
    String login;
    String pass;

    // constructor


    public LoginWithParameters(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student","906090"},
                {"Student","909090"},
                {"Login","909090"}
        });
    }



    @Test
    public void unvalidLoging (){
        loginPage.openPage();
        loginPage.enterTextInToinputLogin(login);
        loginPage.enterTextInToinputPass(pass);
        loginPage.clickOnButtonSubmit();

        checkEcpectedResult("Avatar should not be present", !homePage.isAvatarPresent());
    }
}

package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class LoginWithParams extends ParentTest {
    String login ;
    String pass ;

    public LoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

        @Parameterized.Parameters (name = "Parameters are {0} and {1} ")
        public static Collection testData (){
            return Arrays.asList(new Object[][] {
                    {"Stusent", "979694"},
                    {"Stusent", "909090"},
                    {"login", "909090"}
            });
        }


    @Test
    public void invalidLogin () {

        loginPage.openPage();
        loginPage.enterTextInToInputLogin(login);
        loginPage.enterTextInToInputPass(pass);
        loginPage.clickOnButtonSubmit();

        checkExpectedResult("Avatar should de pressent ", !homePage.isAvatarPresent());



    }






}

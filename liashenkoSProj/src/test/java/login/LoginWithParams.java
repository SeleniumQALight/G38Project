package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


@RunWith(Parameterized.class)//junit говорим что бы запускал этот блок теста с разными параметрами
public class LoginWithParams extends ParentTest {
    String login;
    String pass;

    public LoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parametrs are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student","906090"},
                {"Student","908890"},
                {"login","909090"}

        });
    }

    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin(login);
        loginPage.enterTextInToInputPass(pass);
        loginPage.clickOnButtonSubmit();


        checkExpectedResult("Avatar should not be present"
                ,!homePage.isAvatarPresent());
    }

}

package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginsWithParams extends ParentTest {

    String login;
    String pasw;

    public LoginsWithParams(String login, String pasw) {
        this.login = login;
        this.pasw = pasw;
    }

    @Parameterized.Parameters(name="Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"Login", "909090"}
        });
    }

    @Test
    public void unvalidLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin(login);
        loginPage.enterTextInToInputPass(pasw);
        loginPage.clickOnButtonSubmit();

        checkExpectedResult("Avatar shouldn't be present",
                !homePage.isAvatarPresent());
    }
}

package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithParams extends ParentTest {
    String login;
    String pass;

    public LoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"Student", "9090"},
                {"Login", "909090"}
        });
    }

    @Test
    public void ivalidLogin() {
        loginPages.login(login, pass);

        checkExpectedResult(
                "Avatar is present",
                !homePage.isAvatarPresent()
        );

    }
}

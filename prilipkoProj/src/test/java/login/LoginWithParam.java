package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class LoginWithParam extends ParentTest {

    String LOGIN;
    String PASSWORD;

    public LoginWithParam(String LOGIN, String PASSWORD) {
        this.LOGIN = LOGIN;
        this.PASSWORD = PASSWORD;
    }

    @Parameterized.Parameters(name = "Parametrs are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"Student", "909090"},
                {"Login", "909090"}
        });
    }

    @Test
    public void invalidLogin() {
        loginPage.openPage();

        loginPage.enterTextInToInputLogin(LOGIN);
        loginPage.enterTextInToInputPassword(PASSWORD);
        loginPage.clickOnSubmitButton();

        checkExpectedResult("Avatar is not present", !homePage.isAvatarPresent());
    }
}

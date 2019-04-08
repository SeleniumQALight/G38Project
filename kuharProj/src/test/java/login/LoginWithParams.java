package login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;
// при дебагинге заходит в служебные классы
// вопрос 2: будет ли по пейджОбджекту если групировать методы в один по логике
// градл и мавен

@RunWith(Parameterized.class)
public class LoginWithParams extends ParentTest {

    String login;
    String password;

    public LoginWithParams(String login, String password){
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"Login", "909090"},
                {"Student", "909090"}

        });
    }


    @Test
    public void inValidLogin(){
        loginPage.openPage();
        loginPage.enterTextIntoInputLogin(login);
        loginPage.enterTextIntoInputPass(password);
        loginPage.clickOnButtonSubmit();

        checkExpectedResult("Avatar should not be present", !homePage.isAvatarPresent());
    }
}

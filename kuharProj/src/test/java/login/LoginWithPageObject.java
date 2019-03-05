package login;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {

    @Test
    public void validLogin() {

        loginPage.openPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult(
                "Avatar is not present",
                (Boolean) homePage.isAvatarPresent()
        );
    }

    @Test
    public void invalidLogin(){
        loginPage.login("Invalid login", "909090");
        checkExpectedResult("Avatar was not present",
                !homePage.isAvatarPresent());
    }
}

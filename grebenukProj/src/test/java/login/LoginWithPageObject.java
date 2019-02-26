package login;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {

    @Test
    public void validLogin () {

        loginPage.openPage (); // in LoginPage - we create openPage method
        loginPage.enterTextIntoInputLogin ("Student");
        loginPage.enterTextIntoInputPassword("909090");
        loginPage.clickOnEnterButton();

        checkExpectedResult(
                "Avatar is not Present",
                homePage.isAvatarPresent ()

        );

    }
}

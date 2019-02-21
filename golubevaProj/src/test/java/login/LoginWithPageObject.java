package login;

import org.junit.Test;
import pages.LoginPage;
import perentTest.PerentTest;
public class LoginWithPageObject extends PerentTest{
    @ Test
    public void validLogin () {
        loginPage.openPage ();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSubmit();
        checkExpectedResult(
                "Avatar is not present",
                 homePage.isAvatarPresent()

        );


    }

}

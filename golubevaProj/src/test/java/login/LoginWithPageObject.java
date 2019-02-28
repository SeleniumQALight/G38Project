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

    @Test
    public void inValidLogin(){

        loginPage.login("tttttt", "909090");
        checkExpectedResult("Avatar should not be present",
                !homePage.isAvatarPresent());

    }

}

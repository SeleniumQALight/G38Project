package login;

import org.junit.Test;
import parenttest.Parenttest;

public class LoginWithPageObject extends Parenttest {

    @Test
    public void validLogin() {

        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult("Avatar is not present", homePage.isAvatarPresent());


        }


}

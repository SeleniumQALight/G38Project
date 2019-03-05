package login;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {

    @Test

    public void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSudmit();

        checkExpectedResult (
                "Avatar is not present",
                homePage.isAvatarPresent()
        );


    }

    @Test

    public void invalidLogin (){
       loginPage.login("www","909090");
       checkExpectedResult("Avatar shoud not be present",
               !homePage.isAvatarPresent());
    }
}

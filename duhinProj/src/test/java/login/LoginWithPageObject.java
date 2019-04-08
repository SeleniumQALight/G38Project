package login;

import org.junit.Test;
import pages.LoginPage;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToinputLogin("Student");
        loginPage.enterTextInToinputPass("909091");
        loginPage.clickOnButtonSubmit();

        checkEcpectedResult (
                "Avatar is not present",
                homePage.isAvatarPresent()
        );


    }

    @Test
    public  void invalidLogin () {
        loginPage.login ("ttttt","909090");
        checkEcpectedResult("Avatar is ot presented",!homePage.isAvatarPresent());
    }
}

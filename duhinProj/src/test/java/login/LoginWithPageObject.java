package login;

import org.junit.Test;
import pages.LoginPage;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToinputLogin("Student");
        loginPage.enterTextInToinputPass("909090");
        loginPage.clickOnButtonSubmit();

        checkEcpectedResult (
                "Avatar is not present",
                homePage.isAvatarPresent()
        );


    }
}

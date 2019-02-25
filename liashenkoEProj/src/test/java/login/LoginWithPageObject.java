package login;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject  extends ParentTest {
    @Test
    public void validLogin(){
    loginPages.openPages();
    loginPages.enterTextInToInputLogin("Student");
    loginPages.enterTextInToInputPass("909090");
    loginPages.clickOnButtonSubmit();

    checkExpectedResult(
            "Avatar is not present",
            homePage.isAvatarPresent());

        }
    }

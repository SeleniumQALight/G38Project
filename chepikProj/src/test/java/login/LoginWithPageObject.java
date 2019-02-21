package login;

import org.junit.Test;
import parentTest.ParentTeest;

public class LoginWithPageObject extends ParentTeest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult (
            "Avatar is not present",
        homePage.isAvatarPresent()
        );
    }
}

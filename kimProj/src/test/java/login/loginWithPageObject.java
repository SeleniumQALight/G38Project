package login;

import org.junit.Test;
import parentTest.ParentTest;

public class loginWithPageObject extends ParentTest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToPassword("909090");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult(
                "Avatar is not present",
                homePage.isAvatarPresent()
        );
    }


}

package login;

import javafx.scene.Parent;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult (
                "Avatar is not present",
                homePage.isAvatarPresent ()

        );

    }
}

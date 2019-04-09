package login;

import io.qameta.allure.Step;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {

    @Test
    public void validLogin () {

        loginPage.openPage (); // in LoginPage - we create openPage method
        loginPage.enterTextIntoInputLogin ("Student");
        loginPage.enterTextIntoInputPassword("909060");
        loginPage.clickOnEnterButton();


        checkExpectedResult(
                "Avatar is not Present",
                homePage.isAvatarPresent ()

        );

    }

    @Test
    public void invalidLogin () {
        loginPage.login("hfydhsbhfh", "909090");
        checkExpectedResult("The avatar shouldn't be present",
                !homePage.isAvatarPresent());
    }


}

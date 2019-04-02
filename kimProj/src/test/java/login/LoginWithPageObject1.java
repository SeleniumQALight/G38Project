package login;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject1 extends ParentTest {

    @Issue("7898")
    @Severity(SeverityLevel.BLOCKER)
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

    @Test
    public void invalidLogin() {
        loginPage.login("SashaGrey", "XXX");
        checkExpectedResult("Avatar is present", !homePage.isAvatarPresent()); // "!" - инверсия
    }
}
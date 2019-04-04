package login;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest{

    @Issue("3655")
    @Severity(SeverityLevel.BLOCKER)

    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909060");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult(
                "Avatar is not present",
                homePage.isAvatarPresent()
        );

    }

    @Test
    public void invalidLogin(){
         loginPage.login("tttt","909090");
         checkExpectedResult("Avatar should not be present",
                 !homePage.isAvatarPresent());
    }





}

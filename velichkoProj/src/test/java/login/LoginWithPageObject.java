package login;

import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {

    @Issue("1234")
    @Severity(SeverityLevel.BLOCKER)


    @Test

    public void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909990");
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

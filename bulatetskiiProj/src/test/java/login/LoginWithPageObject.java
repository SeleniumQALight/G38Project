package login;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;



public class LoginWithPageObject extends ParentTest {

    @Issue("2314")
    @Severity(SeverityLevel.BLOCKER)


    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909060");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult (
                "Avatar is not present",
                homePage.isAvatarPresent()
        );
    }

    @Test
    public void invalidLogin (){
        loginPage.login("fdsafas", "909090");
        checkExpectedResult("Avatar should not  be preent", !homePage.isAvatarPresent());
    }
}
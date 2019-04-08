package login;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {

//    @Issue("4846")
//    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void validLogin() {

        loginPage.openPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
       // loginPage.clickOnButtonSubmit();
        checkExpectedResult(
                "Avatar is not present",
                 homePage.isAvatarPresent()
        );
    }

//    @Test
//    public void invalidLogin(){
//        loginPage.login("Invalid login", "906090");
//        checkExpectedResult("Avatar was not present",
//                !homePage.isAvatarPresent());
//    }
}

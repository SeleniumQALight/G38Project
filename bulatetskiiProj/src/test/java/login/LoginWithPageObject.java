package login;

import org.junit.Test;
import parentTest.ParentTest;



public class LoginWithPageObject extends ParentTest {

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

    @Test
    public void invalidLogin (){
        loginPage.login("fdsafas", "909090");
        checkExpectedResult("Avatar should not  be preent", !homePage.isAvatarPresent());
    }
}
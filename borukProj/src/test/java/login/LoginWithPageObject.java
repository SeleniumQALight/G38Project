package login;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import pages.HomePage;
import pages.LoginPage;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSubmit();
        checkExpectedResult("Avatar is not presented", homePage.isAvatarPresent()
        );
    }
    @Test
    public void invalidLogin(){
        loginPage.login("tttt", "909090");
        checkExpectedResult("Avatar should not be presented", !homePage.isAvatarPresent());
    }
}

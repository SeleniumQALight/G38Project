package login;


import org.junit.Test;
import parentTest.ParentTest;


public class LoginWithPageObject extends ParentTest {

    @Test
    public void validLogin() {

        loginPage.openPage();

        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPassword("909090");
        loginPage.clickOnSubmitButton();

        checkExpectedResult(
                "Avatar is not present",
                homePage.isAvatarPresent());
    }

    @Test
    public void invalidLogin() {

        loginPage.login("test", "test");

        checkExpectedResult(
                "Avatar should not be present",
                !homePage.isAvatarPresent());

        checkExpectedResult(
                "Учет запчастей",
                loginPage.getMainHeadline());
    }
}
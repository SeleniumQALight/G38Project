package login;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {
    @Test
    public void  validLogin(){
        loginPage.openPage();
        //loginPage.openPage("http://v3.test.itpmgroup.com"); // без логина
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult(
                "Avatar is not present",
                homePage.isAvatarPresent()
        );
    }
    @Test
    public void invalidLogin() {
        loginPage.login("Studen", "909090");

        checkExpectedResult(
                "Avatar should not be present",
                !homePage.isAvatarPresent());
    }


    // setStatusToChaeckBox(String,Status)
    //checkbox.isSelected&"check".equels(status)
}

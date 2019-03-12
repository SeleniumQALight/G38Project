package login;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginWithPageObject extends ParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSubmit();

        checkExpectedResult(
            "Avatar is not present",
                    homePage.isAvatarPresent()
        );

    }
    @Test
    public void invalidLogin (){
        loginPage.login("tttt","909090");
        checkExpectedResult("Avatar should not be present", !homePage.isAvatarPresent());
    }

    @Test
    public  void selectDeal () {
    loginPage.login("Student","909090");
    dealPage.clickOnButtonDeal();
    dealPage.clickOnButtonAddDeal();
    vocabularyPage.selectDate();
    vocabularyPage.clickSelectTypeDeal();
    vocabularyPage.clickSelectCustomer();
    vocabularyPage.clickSelectProvider();
    vocabularyPage.clickSelectButtonCreat();

        checkExpectedResult(
                "Element is not  present",
                vocabularyPage.selectNewElement()
        );
    }

}

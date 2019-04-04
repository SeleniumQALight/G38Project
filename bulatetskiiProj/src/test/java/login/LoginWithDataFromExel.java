package login;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginWithDataFromExel extends ParentTest {

    @Test
    public void validLogin() throws IOException {
        ExcelDriver exceleDriver = new ExcelDriver ();
        Map dataFromValidLogin = exceleDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.openPage();
        loginPage.enterTextInToInputLogin(dataFromValidLogin.get("login").toString());
        loginPage.enterTextInToInputPass(dataFromValidLogin.get("pass").toString());
        loginPage.clickOnButtonSubmit();

        checkExpectedResult (
                "Avatar is not present",
                homePage.isAvatarPresent()
        );
    }

}



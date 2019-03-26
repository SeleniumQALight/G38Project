package login;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginWithPageObject extends ParentTest {
    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPages.openPages();
        loginPages.enterTextInToInputLogin(dataForValidLogin.get("login").toString());
        loginPages.enterTextInToInputPass(dataForValidLogin.get("pass").toString());
        loginPages.clickOnButtonSubmit();

        checkExpectedResult(
                "Avatar is not present",
                homePage.isAvatarPresent());

    }
}


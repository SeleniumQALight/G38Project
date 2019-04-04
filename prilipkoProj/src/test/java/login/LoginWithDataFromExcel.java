package login;


import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;


public class LoginWithDataFromExcel extends ParentTest {

    @Test
    public void validLogin() throws IOException {

        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");

        loginPage.openPage();

        loginPage.enterTextInToInputLogin(dataForValidLogin.get("correct_login").toString());
        loginPage.enterTextInToInputPassword(dataForValidLogin.get("correct_pass").toString());
        loginPage.clickOnSubmitButton();

        checkExpectedResult(
                "Avatar is not present",
                homePage.isAvatarPresent());
    }
}
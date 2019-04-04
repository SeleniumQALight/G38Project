package login;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTeest;

import java.io.IOException;
import java.util.Map;

public class LoginWithDataFromExcel extends ParentTeest {
    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogon");
        loginPage.openPage();
        loginPage.enterTextInToInputLogin(dataForValidLogin.get("login").toString());
        loginPage.enterTextInToInputPass(dataForValidLogin.get("pass").toString());
        loginPage.clickOnButtonSubmit();

        checkExpectedResult(
                "Avatar is not present",
                homePage.isAvatarPresent()
        );
    }
}

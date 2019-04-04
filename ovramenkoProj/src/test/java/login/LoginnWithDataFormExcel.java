package login;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginnWithDataFormExcel extends ParentTest {

    @Test
    public void invalidLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.openPage();
        loginPage.enterTextInToInputLogin(dataForValidLogin.get("login").toString());
        loginPage.enterTextInToInputPass(dataForValidLogin.get("pass").toString());
        loginPage.clickOnButtonSubmit();

        checkExpectedResult("Avatar should not be present", homePage.isAvatarPresent());
    }
}

package login;

import libs.ExcelDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ParentPage;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginFromDataFromExcel extends ParentTest {


    @Test
    public void validLogin() throws IOException {

        ExcelDriver excelDriver = new ExcelDriver();
        Map datForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");

        loginPage.openPage();
        loginPage.enterTextIntoInputLogin(datForValidLogin.get("login").toString());
        loginPage.enterTextIntoInputPass(datForValidLogin.get("pass").toString());
        loginPage.clickOnButtonSubmit();

        checkExpectedResult(
                "Avatar is not present",
                homePage.isAvatarPresent()
        );
    }
}

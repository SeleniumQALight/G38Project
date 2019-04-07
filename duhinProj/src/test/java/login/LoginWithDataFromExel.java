package login;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginWithDataFromExel extends ParentTest {
@Test
public void validLogin() throws IOException {
    ExcelDriver excelDriver=new ExcelDriver();
    Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
    loginPage.openPage();
    loginPage.enterTextInToinputLogin(dataForValidLogin.get("login").toString());
    loginPage.enterTextInToinputPass(dataForValidLogin.get("pass").toString());
    loginPage.clickOnButtonSubmit();

    checkEcpectedResult(
            "Avatar is not present",homePage.isAvatarPresent()
    );
}
}

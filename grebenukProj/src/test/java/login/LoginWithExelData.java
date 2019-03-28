package login;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginWithExelData extends ParentTest {

    @Test
    public void validLogin () throws IOException {

        ExcelDriver excelDriver = new ExcelDriver(); // created object from Excel driver
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        //configProperties.Data_File = link to file where can be properties and things for method

        loginPage.openPage (); // in LoginPage - we create openPage method
        loginPage.enterTextIntoInputLogin (dataForValidLogin.get("login").toString());
        loginPage.enterTextIntoInputPassword(dataForValidLogin.get("pass").toString());
        loginPage.clickOnEnterButton();

        checkExpectedResult(
                "Avatar is not Present",
                homePage.isAvatarPresent ()

        );

    }

}

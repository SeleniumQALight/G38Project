package login;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

//eg XSSF instead of HSSF
@RunWith(Parameterized.class)
public class InvalidLoginWithDataFromExcel extends ParentTest {

    String login;
    String password;

    public InvalidLoginWithDataFromExcel(String password, String login) {

        this.login = login;
        this.password = password;

    }


    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }


    @Test
    public void invalidLogin(){
        loginPage.login(login,password);
        checkExpectedResult("Avatar was not present",
                !homePage.isAvatarPresent());
    }
}

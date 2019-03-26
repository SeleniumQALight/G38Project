package login;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnvalidLoginWithExcel extends ParentTest{

    String login;
    String pasw;

    public UnvalidLoginWithExcel(String login, String pasw) {
        this.login = login;
        this.pasw = pasw;
    }


    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test
    public void invalidLogin(){
        loginPage.login(login, pasw);

        checkExpectedResult(
                "Avatar shouldn't be present",
                !homePage.isAvatarPresent());
    }
}

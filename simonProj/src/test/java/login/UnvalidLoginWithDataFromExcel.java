package login;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parenttest.Parenttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnvalidLoginWithDataFromExcel extends Parenttest {
    String login;
    String pass;

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    public UnvalidLoginWithDataFromExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Test
    public void invalidLogin() {
        loginPage.login(login, pass);
        checkExpectedResult("Avatar should not present", !homePage.isAvatarPresent());
        // "!" making inversion of method true / false
    }

}

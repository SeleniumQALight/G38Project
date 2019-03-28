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

@RunWith(Parameterized.class) // annotation for ZAPUSK S PARAMETRAMI

public class UnvalidLoginWithExcelData extends ParentTest {
    String login;
    String passw;

    public UnvalidLoginWithExcelData(String login, String passw) {
        this.login = login;
        this.passw = passw;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet //apreadsheet - peremennaya kyda zapisivayoutsia dannue
                = new FileInputStream(configProperties.DATA_FILE_PATH()+"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData(); // Taras oiasnil pochti v conze

    }

    @Test
    public void invalidLogin () {
        loginPage.login(login, passw);
        checkExpectedResult("The avatar shouldn't be present",
                !homePage.isAvatarPresent());
    }


}

package login;

import libs.ExcelDriver;
import libs.UtilsForDB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class LoginWithPageObject extends ParentTest {
    UtilsForDB utilsForDB = new UtilsForDB();
    @Test
    public void validLogin() throws IOException, SQLException, ClassNotFoundException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPages.openPages();
        loginPages.enterTextInToInputLogin(dataForValidLogin.get("login").toString());
        loginPages.enterTextInToInputPass(dataForValidLogin.get("pass").toString());
        loginPages.clickOnButtonSubmit();

        checkExpectedResult(
                "Avatar is not present",
                homePage.isAvatarPresent());
                utilsForDB.getPassForLogin("Student");



    }
    @After
    public void fd() throws SQLException, IOException, ClassNotFoundException {
        Assert.assertEquals(1,utilsForDB.deleteElement("vdsvfs"));
    }
}


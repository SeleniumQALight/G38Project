package testDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDB {
    private Logger logger = Logger.getLogger(getClass());
    Database dbMySQL;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_PADB_DB", "MySQL");
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySQL.selectTable("SELECT * FROM seleniumTable WHERE login = 'ovramenko'");
        logger.info(dataFromSeleniumTable);
//        dbMySQL.changeTable("INSERT INTO seleniumTable VALUES (13, 'ovramenko', 'password')");
        List<ArrayList> dataFromSeleniumTableAfter = dbMySQL.selectTable("SELECT * FROM seleniumTable WHERE login = 'ovramenko'");
        logger.info(dataFromSeleniumTableAfter);

        Assert.assertEquals("", "ovramenko", dataFromSeleniumTableAfter.get(1).get(2));
    }


    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }
}

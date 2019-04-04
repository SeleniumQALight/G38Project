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

    Logger logger = Logger.getLogger(getClass());
    Database dbMySQL;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_PADB_DB", "MySQL");
    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable =
                dbMySQL.selectTable("select * from seleniumTable where login='skljar'");

        logger.info(dataFromSeleniumTable);

//        dbMySQL.changeTable("INSERT INTO seleniumTable VALUES (95, 'skljar', '1qaz')");

        List<ArrayList> dataFromSeleniumTableAfter =
                dbMySQL.selectTable("select * from seleniumTable where login='skljar'");
        logger.info(dataFromSeleniumTableAfter);

        Assert.assertEquals("", "skljar", dataFromSeleniumTableAfter.get(1).get(2));
    }
}
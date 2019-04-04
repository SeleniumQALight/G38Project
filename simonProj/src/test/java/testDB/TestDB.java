package testDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDB {
    Logger logger = Logger.getLogger(getClass());

    Database dbMySql;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {

        dbMySql = new Database("MySQL_PADB_DB", "MySQL");
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable where login='radulenkoTest'");
        logger.info(dataFromSeleniumTable);
       // dbMySql.changeTable("INSERT INTO seleniumTable VALUES (991, 'simon', 'pass') ");
        List<ArrayList> dataFromSeleniumTableAfter =
                dbMySql.selectTable("select * from seleniumTable where login='simon'");
        logger.info(dataFromSeleniumTableAfter);

        Assert.assertEquals("", "simon", dataFromSeleniumTableAfter.get(1).get(2));
    }

    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }


}

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
    Database dbMySql;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB","MySQL");
    }

    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void testDB () throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable where login='boruk'");
        logger.info(dataFromSeleniumTable);
//        dbMySql.changeTable("insert into seleniumTable values (76, 'boruk', 'pass')");
        List<ArrayList> dataFromSeleniumTableAfter = dbMySql.selectTable("select * from seleniumTable where login='boruk'");
        logger.info(dataFromSeleniumTableAfter);

        Assert.assertEquals("Row is presented", "boruk", dataFromSeleniumTableAfter.get(1).get(2));
    }
}

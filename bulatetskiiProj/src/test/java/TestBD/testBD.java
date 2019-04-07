package TestBD;

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

public class testBD {

    Logger logger= Logger.getLogger(getClass());

    Database dbMySql;
    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {

        dbMySql = new Database("MySQL_PADB_DB","MySQL");
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable(
                "select * from seleniumTable where Login = 'bulatetskyi' ");
        logger.info(dataFromSeleniumTable);
//        dbMySql.changeTable("INSERT INTO seleniumTable Value (893, 'bulatetskyi', 'pass')");
        List<ArrayList> dataFromSeleniumTableAfter = dbMySql.selectTable(
                "select * from seleniumTable where Login = 'bulatetskyi' ");
        logger.info(dataFromSeleniumTableAfter);

        Assert.assertEquals("","bulatetskyi", dataFromSeleniumTableAfter.get(1).get(2));
    }




    @After
    public void tearDown() throws SQLException{
        dbMySql.quit();
    }


}

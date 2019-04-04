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
    Logger logger =Logger.getLogger(getClass());
    Database dbMySql;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL" );
    }

    @After
    public  void tearDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList>dataFromSelenimTable =

                dbMySql.selectTable("select * from seleniumTable where login ='velichko'");
        logger.info(dataFromSelenimTable);

//        dbMySql.changeTable("INSERT INTO seleniumTable Value (38,'velichko', 'pass')");
        List<ArrayList>dataFromSelenimTableAfter =
        dbMySql.selectTable("select * from seleniumTable where login ='velichko'");
        logger.info(dataFromSelenimTableAfter);

        Assert.assertEquals(" ", "velichko", dataFromSelenimTable.get(1).get(2));


    }
}

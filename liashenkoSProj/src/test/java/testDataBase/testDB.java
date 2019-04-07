package testDataBase;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testDB {

    Logger logger = Logger.getLogger(getClass());

    Database dbMySql;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql=new Database("MySQL_PADB_DB","MySQL");
    }

    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList>dataFromSeleniumTable=
                dbMySql.selectTable("select * from seleniumTable where login=\"radulenkoTest\"");
        logger.info(dataFromSeleniumTable);
       // dbMySql.changeTable("INSERT INTO seleniumTable VALUES (333,'lyashencoS','pass')");

        List<ArrayList>dataFromSeleniumTableAfter=
                dbMySql.selectTable("select * from seleniumTable where login=\"lyashencoS\"");
        logger.info(dataFromSeleniumTableAfter);

        Assert.assertEquals("Ok Test Finish","lyashencoS",dataFromSeleniumTableAfter.get(1).get(2));

    }
}

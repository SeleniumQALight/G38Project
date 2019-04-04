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
    public void tearnDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable =//select
                dbMySql.selectTable("select * from seleniumTable where login = 'radulenko'");
        logger.info(dataFromSeleniumTable);

        dbMySql.changeTable("INSERT INTO seleniumTable VALUE (1988,'KIM','OLOLO')"); //update
        List<ArrayList> dataFromSeleniumTableAfter =//select
                dbMySql.selectTable("select * from seleniumTable where login = 'KIM'");
        logger.info(dataFromSeleniumTableAfter);
        Assert.assertEquals("KIM is not contains id DB","KIM",dataFromSeleniumTableAfter.get(1).get(2)); //проверка
    }


}

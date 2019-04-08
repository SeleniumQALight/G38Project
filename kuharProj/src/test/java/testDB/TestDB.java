package testDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TestDB {
//    Logger logger = Logger.getLogger(getClass());
    Database dbMySql;


    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB","MySQL");
    }

    @After
    public void disconnectDB() throws SQLException {
        dbMySql.quit();
    }


    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable where login='radulenkoTest'" );

      //  logger.info(dataFromSeleniumTable);
        System.out.print(dataFromSeleniumTable);
//        dbMySql.changeTable("insert into seleniumTable values (78, 'kukhar', 'password')");

        List<ArrayList> dataFromSeleniumTableAfter = dbMySql.selectTable("select * from seleniumTable where login='kukhar'" );
        System.out.print(dataFromSeleniumTableAfter);

//     Assert.assertEquals("radulenko1", dataFromSeleniumTableAfter.get(1).get(2)); - проверка
    }



}

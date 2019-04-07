package testDB;

import libs.Database;
import  org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class TestDB {
    Logger logger = Logger.getLogger(getClass());
    Database dbMySql;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL");


        }
    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void testDB() throws SQLException {
        List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable");
    logger.info(dataFromSeleniumTable);
    dbMySql.changeTable("Insert into seleniumTable Values (45,'dukhnin','pass')");
    List<ArrayList> dataFromSeleniumTableAfter=dbMySql.selectTable("select * from seleniumTable");
        logger.info(dataFromSeleniumTable);

        Assert.assertEquals("","dukhnin",dataFromSeleniumTableAfter.get(1).get(2));

    }
}

package spareTest;


import org.junit.After;
import org.junit.Test;

import parentTest.ParentTest;


public class AddNewSpare extends ParentTest {

    private String SPARE_NAME = "Prylipko_05032019";

    @Test
    public void addNewSpare() {

        sparesPage.openSparePage();

        sparesPage.clickAddButton();

        sparesEditPage.inputSpareName(SPARE_NAME);
        sparesEditPage.selectSparesType("Механика1");
        sparesEditPage.clickOnCreateButton();

        checkExpectedResult("Spare was not added", sparesPage.isSpareInList(SPARE_NAME));
    }

    @After
    public void deleteCreatedSpares() {
        sparesPage.deletingSpareUntilPresent(SPARE_NAME);
    }
}
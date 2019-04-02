package spare;

import org.junit.After;
import org.junit.Test;
import parenttest.Parenttest;

public class AddNewSpare extends Parenttest {

    final String spareName = "simonSpare";

    @Test
    public  void addNewSpare() {
        homePage.goToThisPage();

        sparePage.deleteSpareUntilPresent(spareName);
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.clickOnAddButton();
        editSparePAge.enterSpareNameInToInput(spareName);
        editSparePAge.selectSpareTypeInDD("Механика1");
        editSparePAge.clickOnButtonCreate();
        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));

    }

    @After
    public  void deletingSpare() {
        sparePage.deleteSpareUntilPresent(spareName);
    }
}


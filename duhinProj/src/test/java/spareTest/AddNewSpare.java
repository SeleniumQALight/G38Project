package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    final String spareName = "DukhninSpare";
    @Test
    public void addNewSpare(){
        homePage.goToThisPage ();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();

        checkEcpectedResult("Spare was not added", sparePage.isSpareInList(spareName));
    }

    @After
    public void deletingSpare () {
        sparePage.deletingSpareUntilPresent(spareName);
    }
}

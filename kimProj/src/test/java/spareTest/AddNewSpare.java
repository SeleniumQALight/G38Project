package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    final String spareName = "kimSpare";
    @Test
    public void addNewSpare() {

        homePage.openToThisPage();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpare();
        sparePage.deleteingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickButtonCreate();

        checkExpectedResult("spare was not added", sparePage.isSpareInList(spareName));
    }
}

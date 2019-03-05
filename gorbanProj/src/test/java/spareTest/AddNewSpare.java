package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {

    final String spareName = "gorbanSpare";

    @Test
    public void addNewSpare() {
        homePage.goToThisPage();
        homePage.clickOnMenuDictionary();
        homePage.clickOnsubMenuSpare();
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();

        checkExpectedResult("Spare was not added",
                sparePage.isSpareInList(spareName));
    }

}

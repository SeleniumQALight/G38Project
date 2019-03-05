package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    String spareName = "BorukSpare";

    @Test
    public void addNewSpare() throws InterruptedException {
        homePage.goToThisPage();
        homePage.clickOnMenuDictionary();
        Thread.sleep(200);
        homePage.clickOnSubMenuSpare();
        sparePage.deleteingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage. selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();
        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));


    }
}

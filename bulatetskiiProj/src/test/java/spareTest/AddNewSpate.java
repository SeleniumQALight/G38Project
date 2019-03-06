package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpate extends ParentTest {
    final String spareName = "bulatetskyiSpare";

    @Test

    public void addNewSpare (){
        homePage.goToThisPage ();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnButton();
        editSparePage.enterSpareNameInToInput (spareName);
        editSparePage.selectSpareTypeInDD ("Механика1");
        editSparePage.clickOnButtonCrete ();

        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));
    }

}

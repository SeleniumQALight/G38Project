package spareTest;

import org.junit.After;
import org.junit.Test;
import pages.SparePage;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    final String spareName = "bybybySpare";

    @Test
    public void addNewSpare () {
        homePage.goToThisPage ();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.deletingSpareUntilPresent (spareName);
        sparePage.clickOnAddButton ();
        spareEditPage.enterSpareNameIntoInput(spareName);
        spareEditPage.selectSpareTypeInDD ("Механика1");
        spareEditPage.clickOnButtonCreate ();

        checkExpectedResult("Spare wasn't added",  sparePage.isSpareInList (spareName));

    }


    @After
    public void deletingSpare () {
        sparePage.deletingSpareUntilPresent(spareName);
    }
}

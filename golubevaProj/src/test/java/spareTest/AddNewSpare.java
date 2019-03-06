package spareTest;

import org.junit.Test;
import perentTest.PerentTest;

public class AddNewSpare extends PerentTest {
    final String spareName = "golubevaSpare";
    @Test
    public void addNewSpare (){


        homePage.openToThisPage ();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.deletedSpareUntilPresetn(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();
        checkExpectedResult("Spare was not added",sparePage.isSpareInList(spareName));


    }

}

package sparTest;

import org.junit.Test;
import parentTest.ParentTeest;

public class AddnewSpare extends ParentTeest {
    final String spareName = "chepikSpare";
    @Test
    public void addnewSpare() {
        homePage.goToThisPage();
        homePage.clickOnMenuDictionary();
        homePage.clickOnMenuSpare();
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();

        checkExpectedResult("Spare was not added", sparePage.isSpareInList(spareName));
    }
}

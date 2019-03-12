package sparSpare;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {

    final String spareName = "skljarSpare";

    @Test
    public void addNewSpare(){
        homePage.goToThisPage();
        homePage.clickOnMenuictitionary();
        homePage.clickOnSubMenuSpare();
        sparePage.deletingSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectSpareTypeInDD("Механика1");
        editSparePage.clickOnButtonCreate();

        checkExpectedResult("Spare was not added",
                sparePage.isSpareinList(spareName));
    }
}

package spare;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
final String spareName="lyashenco";
    @Test
    public void addNewSpare(){
         homePage.goToThisPage();
         homePage.clickOnMenuDictionary();
         homePage.clickOnSabMenuSpare();
         sparPage.deletingSpareUntilPresent(spareName);
         sparPage.clickOnAddButton();
         editSparePage.enterSparenNameInToInput(spareName);
         editSparePage.selectSparTypeInDD("Механика1");
         editSparePage.clickOnButtonCreate();

         checkExpectedResult("Spare was not added",
                 sparPage.isSpareInList(spareName));
    }

    @After
    public void deletimgSpare(){
        sparPage.deletingSpareUntilPresent(spareName);
    }

}

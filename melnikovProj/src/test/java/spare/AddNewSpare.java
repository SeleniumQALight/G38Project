package spare;

import mainPack.pages.ParentPage;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
        homePage.goToThisPage();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameInToInput();
        editSparePage.SelectSpareTypeInDD("Механика1");
        editSparePage.clickONButtonCreate();
    }

}

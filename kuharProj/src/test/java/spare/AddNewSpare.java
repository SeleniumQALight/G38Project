package spare;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {

    final String spareName = "KuharSpare12";


    //TODO @after in ParentTest run after any single test but we can use additional @after after our test




    @Test
    public void addNewSpare (){

        homePage.goToHOMEPage();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();


        sparePage.deletingSpareUntilPresent(spareName);

        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectSpareTypeInDropDown("Механика1");
        editSparePage.clickOnButtonCreate();

        checkExpectedResult("Spare was not created",sparePage.isSpareInList(spareName));

    }

    @After
    public void deletingSpareUntilPresent (){
        sparePage.deletingSpareUntilPresent(spareName);
    }



}

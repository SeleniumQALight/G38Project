package spareTest;


import org.junit.Test;

import parentTest.ParentTest;


public class AddNewSpare extends ParentTest {

    private String SPARE_NAME = "Prylipko_05032019";
    // String SPARE_NAME = "Prylipko_" + formatForDateNow.format(dateNow);
    @Test
    public void addNewSpare() {

        loginPage.login(LOGIN, PASSWORD);

        checkExpectedResult("Avatar is not present",homePage.isAvatarPresent());

        homePage.clickOnDictionaryMenu();
        homePage.clickOnSubMenuSpares();

        sparesPage.deletingSpareUntilPresent(SPARE_NAME);

        sparesPage.clickAddButton();

        sparesEditPage.inputSpareName(SPARE_NAME);
        sparesEditPage.selectSparesType("Механика1");
        sparesEditPage.clickOnSubmitButton();

        checkExpectedResult("Spare was not added", sparesPage.isSpareInList(SPARE_NAME));
    }
}
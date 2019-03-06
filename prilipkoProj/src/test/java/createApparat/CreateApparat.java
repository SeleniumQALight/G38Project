package createApparat;


import org.junit.Test;

import parentTest.ParentTest;


public class CreateApparat extends ParentTest {

    @Test
    public void createApparat() {

        loginPage.login(LOGIN, PASSWORD);

        homePage.clickOnDictionaryMenu();
        homePage.clickOnSubMenuApparat();

        apparatPage.clickAddButton();

        apparatEditPage.inputApparatNumber("6237");
        apparatEditPage.inputApparatComment("Mitsubishi Lancer, SN: " + formatForDateNow.format(dateNow));
        apparatEditPage.clickOnCreateButton();
    }
}

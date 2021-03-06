package createProviders;


import org.junit.Test;

import parentTest.ParentTest;


public class CreateProviders extends ParentTest {

    @Test
    public void createProviders() {

        loginPage.login(LOGIN, PASSWORD);

        homePage.clickOnDictionaryMenu();
        homePage.clickOnSubMenuProviders();

        providersPage.openFirstProvidersInList();

        providersEditPage.privatPersonCheckbox("unchecked");
        providersEditPage.isOurFirmCheckbox("checked");
        providersEditPage.clickOnCreateButton();
    }
}
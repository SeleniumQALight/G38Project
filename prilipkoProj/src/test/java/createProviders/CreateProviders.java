package createProviders;


import org.junit.Test;
import parentTest.ParentTest;


public class CreateProviders extends ParentTest {

    @Test
    public void createProviders() {

        loginPage.login(LOGIN, PASSWORD);

        homePage.clickOnDictionaryButton();
        homePage.clickProvidersButton();

        providersPage.openFirstProvidersInList();

        providersEditPage.privatPersonCheckbox("checked");
        providersEditPage.isOurFirmCheckbox("null");
        providersEditPage.clickOnSubmitButton();
    }
}
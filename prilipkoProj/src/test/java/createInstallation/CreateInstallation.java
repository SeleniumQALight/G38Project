package createInstallation;


import org.junit.Test;

import parentTest.ParentTest;


public class CreateInstallation extends ParentTest {

    @Test
    public void createInstallation(){

        loginPage.login(LOGIN, PASSWORD);

        homePage.clickOnDictionaryMenu();
        homePage.clickOnSubMenuApparat();

        apparatPage.clickAddButton();

        apparatEditPage.inputApparatNumber("6237");
        apparatEditPage.inputApparatComment("Mitsubishi Lancer, SN: " + formatForDateNow.format(dateNow));
        String APPARAT = apparatEditPage.getApparatComment();
        apparatEditPage.clickOnCreateButton();

        apparatEditPage.clickOnSubMenuWorkers();

        workersPage.clickAddButton();

        String WORKER_MIDDLE_NAME = "Anatolievich_" + formatForDateNow.format(dateNow);

        workersEditPage.inputWorkerSurname("Prylipko");
        workersEditPage.inputWorkerName("Oleksandr");
        workersEditPage.inputWorkerMiddleName(WORKER_MIDDLE_NAME);
        workersEditPage.inputWorkerPhone("+38(063)834-99-22");
        workersEditPage.clickOnCreateButton();

        workersPage.clickOnInstallationMenu();

        installationPage.clickAddButton();

        installationEditPage.selectInstallationDate("15", "7", "2014", "13", "45");
        installationEditPage.selectInstallationApparat(APPARAT);
        installationEditPage.selectWorker(WORKER_MIDDLE_NAME);
        installationEditPage.clickOnCreateButton();
    }
}
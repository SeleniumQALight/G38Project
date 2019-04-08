package service;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewService extends ParentTest {


    @Test
    public void clickOnDropDownItem(){
        homePage.goToHOMEPage();
        homePage.clickOnServiceMenu();

        servicePage.deletingServiceUntilPresent("service-changes-test");
        servicePage.clickOnAddButton();

        editServicePage.addServiceChangesIntoInput("service-changes-test");
        editServicePage.addServiceOperationsIntoInput("service-operations-test");
        editServicePage.selectServiceDateDAY("28");
        editServicePage.selectServiceDateMONTH("нояб.");
        editServicePage.selectServiceDateYEAR("2023");
        editServicePage.selectServiceDateHOURS("23");
        editServicePage.selectServiceDateMINUTES("23");
        editServicePage.addAparatIntoDD("Машина времени");
        editServicePage.addSotrudnikIntoDD("Порошенко Петр Олегович");
        editServicePage.clickOnButtonCreate();
    }
}

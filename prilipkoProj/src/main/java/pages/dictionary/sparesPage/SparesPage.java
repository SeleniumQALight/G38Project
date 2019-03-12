package pages.dictionary.sparesPage;


import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.DashboardPage;
import pages.LoginPage;
import pages.ParentPage;


public class SparesPage extends ParentPage {

    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement addButton;


    public SparesPage(WebDriver driver) {
        super(driver);
    }


    public void openSparePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Student", "909090");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnDictionaryMenu();
        dashboardPage.clickOnSubMenuSpares();
    }

    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements.isElementPresent(By.xpath(".//*[text()='"+spareName+"']"));
    }

    public void deletingSpareUntilPresent(String spareName) {
        int counter = 0;
        SparesEditPage sparesEditPage = new SparesEditPage(driver);
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            sparesEditPage.clickDeleteButton();
            counter++;
            if (counter > 100) {
                Assert.fail("There are more than 100 spare");
            }
        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(By.xpath(".//*[text()='"+spareName+"']"));
    }
}
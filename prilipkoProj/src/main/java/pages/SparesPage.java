package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SparesPage extends ParentPage {

    public SparesPage(WebDriver driver) {
        super(driver);
    }

    public void openSparePage() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Student", "909090");
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
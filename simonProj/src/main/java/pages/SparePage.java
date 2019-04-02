package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends ParentPage {


    @FindBy(className = "fa fa-plus")
    private WebElement addButton;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickOnAddButton() {
        actionWithOurElements.clickOnElement(addButton);
    }

    public boolean isSpareInList(String spareName) {
        return actionWithOurElements.isElementPresent(By.xpath(".//*[text()=' " + spareName + " ']"));
    }

    public void deleteSpareUntilPresent(String spareName) {
        int counter = 0;
        EditSparePAge editSparePAge = new EditSparePAge(webDriver);
        while (isSpareInList(spareName)) { // цикл будет выполняться пока spareName = true
            clickOnSpare(spareName);
            editSparePAge.clickOnButtonDelete();

            counter++;
            if (counter > 100) {
                Assert.fail("There are more than 100 spares");
            }

        }
    }

    private void clickOnSpare(String spareName) {
        actionWithOurElements.clickOnElement(By.xpath(".//*[text()=' " +spareName + " ']"));
    }
}

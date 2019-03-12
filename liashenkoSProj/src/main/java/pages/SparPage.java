package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparPage extends PerentPage {
    @FindBy(xpath = "//*[@class='fa fa-plus']")
    private WebElement bottonAdd;

    public SparPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickOnAddButton() {
        actionsWithOurElements.clickOnElement(bottonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithOurElements
                .isElementPresent(By.xpath(".//*[text()='"+spareName+"']"));
    }

    public void deletingSpareUntilPresent(String spareName) {
        int counter =0;
        EditSparePage editSparePage=new EditSparePage(webDriver);
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickOnButtonDelete();
            counter ++;
            if (counter>100){
                Assert.fail("There are more than 100 spare");
            }
        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithOurElements.clickOnElement(By.xpath(".//*[text()='"+spareName+"']"));
    }
}

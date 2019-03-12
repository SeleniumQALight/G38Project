package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends ParentPage {

    @FindBy(className = "box-tools")
//    @FindBy(xpath = "//*[@class='fa fa-plus']") //предложено на уроке
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickOnAddButton() {
        actionsWithElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithElements
                .isElementDisplayed(By.xpath(".//*[text()='"+spareName+"']"));
    }

    public void deleteingSpareUntilPresent(String spareName) {
        int counter = 0;
        EditSparePage editSparePage = new EditSparePage(webDriver);
        while (isSpareInList(spareName)){
            clickOnSpare(spareName);
            editSparePage.clickButtonDelete();
            counter ++;
            if(counter > 100) {
                Assert.fail("There are more then 100 spare with "+spareName+" NAME");
            }
        }
    }

    private void clickOnSpare(String spareName) {
        actionsWithElements.clickOnElement(By.xpath(".//*[text()='"+spareName+"']"));
    }
}

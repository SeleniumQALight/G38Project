package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealPage extends PerentPage {
    public DealPage(WebDriver webDriver) {
        super(webDriver);

    }
    @FindBy(xpath = ".//ul[@class='sidebar-menu']//li[@id='deal']")
    private WebElement deal;

    @FindBy(xpath = ".//a[@href='http://v3.test.itpmgroup.com/deal/edit']")
    private WebElement addDeal;

    public void clickOnButtonDeal() {
      /*  try {
           button.click();
            System.out.println("Button Submit was clicked ");
        }catch (Exception e) {
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }*/
        actionsWithOurElements.clickOnElement(deal);
    }
    public  void clickOnButtonAddDeal(){
        actionsWithOurElements.clickOnElement(addDeal);
    }
}

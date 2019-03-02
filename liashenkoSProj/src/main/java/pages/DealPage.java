package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealPage extends PerentPage {
    public DealPage(WebDriver webDriver) {
        super(webDriver);

    }
    @FindBy(xpath = ".//a[@href='/deal']")
    private WebElement deal;

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
}

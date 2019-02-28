package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ActionsWithOurElements {
    WebDriver webDriver;
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        Logger logger =Logger.getLogger(getClass());
    }
    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            System.out.println(text + "was input into element");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        System.out.println("Cannot work with element" + e);
        Assert.fail("Cannot work with element" + e);
    }
        public void clickOnElement(WebElement element){
            try {
               element.click();
                System.out.println("Element was clicked");

        }catch (Exception e){
                printErrorAndStopTest(e);
            }
        }

}

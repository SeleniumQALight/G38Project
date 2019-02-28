package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " input");
        } catch (Exception e) {
          printErrorAndStopTest(e);

        }
    }


    private void printErrorAndStopTest(Exception e) {
        System.out.print("Can not work with element" + e);
       Assert.fail("Can not work with element" + e);


    }


    public void clickOnElement(WebElement element) {
        try {
            element.click();
            System.out.print("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }
}

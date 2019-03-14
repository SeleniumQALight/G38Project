package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys();
            logger.info(text + " was input in toelement");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not workwith element" + e);
        Assert.fail("Can not workwith element" + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Elementwas clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }
}


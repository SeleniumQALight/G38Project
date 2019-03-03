package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements (WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void clickOnElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was input onto element");
        } catch (Exception e) {
            printErrorAndStopTest (e);
        }


    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with Element" + e );
        Assert.fail("Cannot work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent (WebElement Element) {
        try {
            boolean isDisplayed = Element.isDisplayed();
            logger.info("Element is displayed -" + true);
            return isDisplayed;
        } catch (Exception e) {
            logger.info("Element is displayed -" + false);
            return false;
        }
    }

    public void selectTextInDropdown (WebElement element, String text) {
        try {
            Select select = new Select(element);// org.openqa.selenium...
            select.selectByVisibleText(text);
            logger.info(text + "was selected in dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDropdown (WebElement element, String value) {
        try {
            Select select = new Select(element);// org.openqa.selenium...
            select.selectByValue(value);
            logger.info(value + "was selected in dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }
}

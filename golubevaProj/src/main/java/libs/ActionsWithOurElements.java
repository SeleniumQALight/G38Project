package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was input into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);

        }


    }

    private void printErrorAndStopTest(Exception e) {
        logger.info("Cannot work with element ");
        Assert.fail("Cannot work with element" + e);
    }

    public void click(WebElement element) {
        try {
            element.click();
            logger.info("Element was cliked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            boolean isDisplayed = webElement.isDisplayed();
            logger.info("Element is displayed ->" + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.info("Element is displayed -> false");
            return false;
        }
    }

    public void selectTextInDrobDown(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + "Was Selected in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }
    public void selectTextInDeopDown(WebElement element, String value){
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info(value + "Was Selected in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }


    public boolean isElementPresent(By xpath) {
        try {
            return isElementPresent((webDriver.findElement(xpath)));
        } catch (Exception e) {
            return false;
        }
    }

    public void click(By xpath) {
        try {
            click(webDriver.findElement(xpath));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}
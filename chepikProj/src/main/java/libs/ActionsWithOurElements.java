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

    public void enterTextIntoElement (WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was input into element ");
        }catch (Exception e) {
            printErrorAndStopTest (e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element " + e);
        Assert.fail("Cannot work with element " + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent (WebElement webElement) {
        try {
            boolean isDisplayed = webElement.isDisplayed();
            logger.info("Element is displayed -> " + isDisplayed);
           return isDisplayed;
        }catch (Exception e) {
            logger.info("Element is displayed -> false");
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + " was seleected in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDD(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info(value + " was seleected in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent(By xpath) {
        try {
            return isElementPresent(webDriver.findElement(xpath));
        }catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(By xpath) {
    try {
        clickOnElement(webDriver.findElement(xpath));
    }catch (Exception e) {
        printErrorAndStopTest(e);
    }
    }

//    public void setStatusToCheckBox (WebElement element, String text) {
//        if (checkbox != selected ) {
//
//        }
//
//    }
}

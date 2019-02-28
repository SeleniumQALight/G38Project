package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass()); //инициализировали логер

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info( text + " was input into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Stop test and print ERROR
     * @param e
     */
    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try{
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element is displayed -> " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.info("Element is displayed -> false + "+ e);
            return false;
        }
    }

    public void selectTextInDropDown(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in drop-down");
        } catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDropDown(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in drop-down");
        } catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    //Select value in dropdown by UI
    // checkbox.isSeleted -3 statuses method "if" Webelement element, Strint status
}
package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait10, wait15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 10);
        wait15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was input into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element" + e);
        Assert.fail("Cannot work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(element + " was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element is displayed = " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.info("Element is displayed = FALSE");
            return false;
        }
    }

    public void selectTextInDropdown(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + "was selected in dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDropdown(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info(value + "was selected in dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent(By xpath) {
        try {
            return isElementPresent(webDriver.findElement(xpath));
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(By xpath) {
        try {
            clickOnElement(webDriver.findElement(xpath));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    public void statusToCheckbox(WebElement element, String neededStates) {
        if ("check".equals(neededStates) || "uncheck".equals(neededStates)) {
            try {
                if (element.isSelected() && "check".equals(neededStates)) {
                    logger.info("Already checked");
                } else if (!element.isSelected() && "check".equals(neededStates)) {
                    element.click();
                    logger.info("Checkbox checked");
                } else if (element.isSelected() && "uncheck".equals(neededStates)) {
                    element.click();
                    logger.info("Checkbox checked");
                } else if (!element.isSelected() && "uncheck".equals(neededStates)) {
                    logger.info("Checkbox is unchecked");
                }
            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        } else {
            logger.error("state should be 'check' or 'uncheck'");
            Assert.fail("state should be 'check' or 'uncheck'");
        }
    }

}

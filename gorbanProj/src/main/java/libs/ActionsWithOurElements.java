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

    public void enterTextIntoElement(WebElement element, String text) {
        try {

            element.clear();
            element.sendKeys(text);
            //System.out.println(text + " was input into element"); // добавили логер logger
            logger.info(text + " was input into element");
        } catch (Exception a) {
            printErrorAndStopTest(a);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        //System.out.println("Cannot work with element " + e);
        logger.error("Cannot work with element " + e);
        Assert.fail("Cannot work with element " + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));
//            wait10.until(ExpectedConditions.not(
//                    ExpectedConditions.elementToBeClickable(element)
//            ));
            element.click();
            // System.out.println("Element was clicked");
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            boolean isDisplayed = webElement.isDisplayed();
            logger.info("Element is displayed " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.info("Element is displayed -> false");
            return false;
        }
    }


    public void selectTextInDropdown(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info("Text " + text + " was selected in dropdown " + element);

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    //TODO:
    public void selectValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info("Value " + value + " was selected in dropdown");

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

    public void setStatusToCheckBox(WebElement element, String neededState) {
        if ("check".equals(neededState) || "uncheck".equals(neededState)) {
            try {
                if (element.isSelected() && "check".equals(neededState)) {
                    logger.info("Already check");
                } else if (!element.isSelected() && "check".equals(neededState)) {
                    element.click();
                    logger.info("check box checked");
                } else if (element.isSelected() && "uncheck".equals(neededState)) {
                    element.click();
                    logger.info("check box deselected");

                } else if (!element.isSelected() && "uncheck".equals(neededState)) {
                    logger.info("checkbox is already unchecked");
                }

            } catch (Exception e) {
                printErrorAndStopTest(e);
            }

        } else {
            logger.error("State should be 'check' or 'uncheck'");
            Assert.fail("State should be 'check' or 'uncheck'");
        }
    }
}
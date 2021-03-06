package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
        wait15 = new WebDriverWait(webDriver,15);

    }


    public void clickOnElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was input onto element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }


    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with Element" + e);
        Assert.fail("Cannot work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));

            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent(WebElement Element) {
        try {
            boolean isDisplayed = Element.isDisplayed();
            logger.info("Element is displayed -" + true);
            return isDisplayed;
        } catch (Exception e) {
            logger.info("Element is displayed -" + false);
            return false;
        }
    }

    public void selectTextInDropdown(WebElement element, String text) {
        try {
            Select select = new Select(element);// org.openqa.selenium...
            select.selectByVisibleText(text);
            logger.info(text + "was selected in dropdown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was input into element ");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDropdown(WebElement element, String value) {
        try {
            Select select = new Select(element);// org.openqa.selenium...
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

    public void setStatustoCheckbox(WebElement element, String neededToBecome) {
        if ("check".equals(neededToBecome) || "uncheck".equals(neededToBecome)) {
            try {
                if (element.isSelected() && "check".equals(neededToBecome)){
                    logger.info("Already element is checked");
                } else if (!element.isSelected() && "check".equals(neededToBecome)) { // 1 - состояние - не выбран элемент,
                    // вторая часть - состояние в котором должен быть выбран чекбокс - тогда делаем то,
                    //что приводит к этому состоянию (кликаем)
                    element.click();
                    logger.info("We checked check box because it wasn't selected");
                } else if (element.isSelected() && "uncheck".equals(neededToBecome)) {
                    element.click();
                    logger.info("We uncheck the element");
                } else if (!element.isSelected() && "uncheck".equals(neededToBecome)) {
                    logger.info("Checkboks is unchecked and it need to ne so");
                }

            } catch (Exception e) {
                printErrorAndStopTest(e);
            }

        } else {
            logger.error("State should e 'check' or 'uncheck'");
            Assert.fail("State should be 'check' or 'uncheck'");
        }
    }
}

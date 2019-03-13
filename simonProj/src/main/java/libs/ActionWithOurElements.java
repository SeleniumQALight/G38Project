package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait10, wait15;


    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver, 10);
        wait15 = new WebDriverWait(webDriver, 15);

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

    private void waitElement(WebElement element, WebDriverWait wait) {
       wait.until(ExpectedConditions.elementToBeClickable(element)); // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
    }

    public void clickOnElement(WebElement element) {
        try {
            waitElement(element, wait10);
            element.click();
            System.out.print("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    public boolean isElementPresent(WebElement element) {
        try {
            boolean isDisplaying = element.isDisplayed();
            logger.info("ELement is displaying" + isDisplaying);
            return isDisplaying;
        } catch (Exception e) {

            logger.info("ELement is not displaying");
            return false;

        }
    }

    public void selectTextInDropDown(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + "was selected in drop down");
        } catch (Exception e) {
            printErrorAndStopTest(e);

        }

    }

    public void selectValueInDropDown(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info(value + "was selected in drop down");
        } catch (Exception e) {
            printErrorAndStopTest(e);

        }

    }

    public void setCheckBoxValue(WebElement element) {
        try {
            element.isDisplayed();
            logger.info("Check box is displaying");
            if (element.isSelected())
                logger.info("Checkbox value has already been set");
            else {
                element.click();
                logger.info("Checkbox value is checked");
            }
        } catch (Exception e) {
            logger.info("Prive Person check box is NOT displaying");
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
                } else if (!element.isSelected() && "unckech".equals(neededState)) {
                    logger.info("unchecked");
                }
            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        } else {
            logger.error("State should be 'check' or 'uncheck'");
            Assert.fail("State should be 'check' or 'uncheck'");
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
}

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

    WebDriver driver;

    private Logger logger = Logger.getLogger(getClass());
    private WebDriverWait wait10, wait15;

    public ActionsWithOurElements(WebDriver driver) {
        this.driver = driver;
        wait10 = new WebDriverWait(driver, 10);
        wait15 = new WebDriverWait(driver, 15);
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was input into element"); //Просто информация
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            wait15.until(ExpectedConditions.elementToBeClickable(webElement));
            String buttonName = webElement.getText();
            webElement.click();
            logger.info("Element " + "'" + buttonName + "'" +" was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(By xpath) {
        try {
            clickOnElement(driver.findElement(xpath));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            boolean isDisplayed = webElement.isDisplayed();
            logger.info("Element is displayed -> " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }
    }

    public boolean isElementPresent(By xpath) {
        try {
            return isElementPresent(driver.findElement(xpath));
        } catch (Exception e) {
            return false;
        }
    }

    // SELECT
    public void selectValueInDropdown(WebElement webElement, String value) {
        try {
            Select select = new Select(webElement);
            select.selectByValue(value);
            logger.info(value + " is selected in drop-down");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    // SELECT
    public void selectVisibleTextInDropdown(WebElement webElement, String text) {
        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(text);
            logger.info(text + " is selected in drop-down");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    // SELECT
    public void selectTextInDropdownByUi(WebElement WebElement, String text) {
        try {
            WebElement.click();
            driver.findElement(By.xpath(".//option[contains(text(),'"+text+"')]")).click();
            logger.info(text + " is selected in drop-down");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    // CHECKBOX
    public void setStatusToCheckbox(WebElement webElement, String status) {
        try {
            if("checked".equals(status)){
                if(webElement.isSelected()) {
                    logger.info("Checkbox has been activated");
                }
                else if(!webElement.isSelected()) {
                    webElement.click();
                    logger.info("Checkbox activated");
                }
            }
            if("unchecked".equals(status)) {
                if(webElement.isSelected()) {
                    webElement.click();
                    logger.info("Checkbox deactivated");
                }
                else if(!webElement.isSelected()) {
                    logger.info("Checkbox has been deactivated");
                }
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void setStatusToCheckboxV2(WebElement element, String neededStatus) {
        if ("checked".equals(neededStatus) || "unchecked".equals(neededStatus)) {
            try {
                if(element.isSelected() && "checked".equals(neededStatus)) {
                    logger.info("Already checked");
                } else if(!element.isSelected() && "checked".equals(neededStatus)) {
                    element.click();
                    logger.info("Checkbox checked");
                } else if(element.isSelected() && "unchecked".equals(neededStatus)) {
                    element.click();
                    logger.info("Checkbox unchecked");
                } else if (!element.isSelected() && "unchecked".equals(neededStatus)) {
                    logger.info("Already unchecked");
                }
            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        } else {
            logger.error("State should be 'checked' or 'unchecked'");
            Assert.fail("State should be 'checked' or 'unchecked'");
        }
    }
// *********************************************************************************************************************
    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element " + e); //Вывод ошибки
        Assert.fail("Cannot work with element " + e);
    }
}
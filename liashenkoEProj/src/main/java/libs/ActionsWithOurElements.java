package libs;

import org.apache.commons.net.ntp.TimeStamp;
import org.apache.log4j.Logger;
import org.junit.Assert;
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

    public  void clickOnButton(WebElement element) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void enterTextInToElement(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was input into element");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element" + e);
        Assert.fail("Cannot work with element" + e );
    }

    public boolean isAlementPresent(WebElement element){
        try {
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element is displayed ->" + isDisplayed);
           return element.isDisplayed();
        }catch (Exception e){
            logger.info("Element is displayed -> false");
            return false;
        }

    }

    public void selectValueInDD(WebElement element, String value){
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info(value + " was selected in DD");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void setStatusToCheckBox(WebElement element, String status){
        if ("check".equals(status)|| "uncheck".equals(status)){
            try {
        if (element.isSelected()&& "check".equals(status)){
            logger.info("Already check");
        }else if (!element.isSelected() && "check".equals(status)){
            element.click();
            logger.info("check box checked");
        }else if (element.isSelected() && "uncheck".equals(status)){
            element.click();
            logger.info("check box deselected");
        }else if (!element.isSelected() && "uncheck".equals(status)){
            logger.info("check box is already unchecked");
        }
            }catch (Exception e){
                printErrorAndStopTest(e);
            }
        }else {
            logger.error("State should be 'check' or 'uncheck'");
            Assert.fail("State should be 'check' or 'uncheck'");
        }
    }

    }



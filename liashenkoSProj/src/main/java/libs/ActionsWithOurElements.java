package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger=Logger.getLogger(getClass());
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver=webDriver;
    }
    public void enterTextInToElement(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
           logger.info(text + " "+ "was input into element");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest( Exception e) {
       logger.error(" Cannot work with element" + e);
        Assert.fail(" Cannot work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");

        }catch (Exception e){
            printErrorAndStopTest(e);
        }

    }

    public  boolean isElementPresent (WebElement webElement){
        try {
            boolean isDisplayed = webElement.isDisplayed();
            logger.info("Element isDisplayed ->" + isDisplayed);
          return   isDisplayed;
        }catch (Exception e){
            logger.info("Element isDisplayed -> false");
            return false;
        }
    }
    public void slectTextInDD(WebElement element, String text){
        try {
            Select select=new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + "was selected in DD");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    public void slectValueInDD(WebElement element, String value){
        try {
            Select select=new Select(element);
            select.selectByValue(value);
            logger.info(value + "was selected in DD");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
}

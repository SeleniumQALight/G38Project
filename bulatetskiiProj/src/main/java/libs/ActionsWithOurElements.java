package libs;

import org.apache.bcel.ExceptionConstants;
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
    WebDriverWait weit10, weit15;
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        weit10 = new WebDriverWait(webDriver, 10);
        weit15 = new WebDriverWait(webDriver, 15);

    }
    public void enterTextInToElement (WebElement element, String text){
        try{
            weit10.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
            logger.info(text + "was input into element");
        } catch (Exception e){
            printErrorAndStopTest (e);
        }


    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element" + e);
        Assert.fail("Cannot work with element" + e);
    }


    public void clickOnElement(WebElement element) {
        try {

            element.click();
            logger.info("Elemen was clicked");
        } catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    public boolean isElementPresent(WebElement webElement){
        try {
            boolean isDispleed = webElement.isDisplayed();
            logger.info("Element is desplayed -->" + isDispleed);
           return isDispleed;

        }catch (Exception e){
            logger.info("Element is desplayed --> false" );
            return false;
        }
    }

    public void selectTextInDD(WebElement element, String text){
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info(text + "was selected in DD");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
    public void selectValueInDD(WebElement element, String value){
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info(value + "was selected in DD");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
  /*  public  void setStatusToCheckbox (String status, WebElement checkBox){
        try {
            if (checkBox.isSelected() && checkBox.equals(status)){
                logger.info("Checkbox was enabled");
            }
            checkBox.click();
            logger.info("Checkbox was disabled and click on it" );


        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    } */

    public boolean isElementPresent(By xpath) {
        try {
            return isElementPresent(webDriver.findElement(xpath));

        }catch (Exception e){
            return false;
        }
    }

    public void clickOnElement(By xpath) {
        try {
            clickOnElement(webDriver.findElement(xpath));


        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
        public void setStatusToCheckBox (WebElement element, String needesStatus){
            if ("check".equals(needesStatus) || "uncheck".equals(needesStatus)){
                try {
                    if (element.isSelected() && "check".equals(needesStatus)){
                        logger.info("Already chack");
                    } else if (!element.isSelected() && "check".equals(needesStatus)){
                        element.click();
                        logger.info("check box checked");
                    } else if (element.isSelected() && "uncheck".equals(needesStatus)){
                        element.click();
                        logger.info("check box deselected");
                    } else if (!element.isSelected() && "uncheck".equals(needesStatus)){
                        logger.info("check box is already unchecked");
                    }


                }catch (Exception e){
                    printErrorAndStopTest(e);
                }

            }else {
                logger.error("Statute should be 'Check' or 'uncheck'");
                Assert.fail("Statute should be 'Check' or 'uncheck'");

            }


        }
}

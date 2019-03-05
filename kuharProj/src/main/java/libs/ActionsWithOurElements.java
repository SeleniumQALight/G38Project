package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;

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
            element.click();
           // System.out.println("Element was clicked");
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementPresent (WebElement webElement){
        try {
            boolean isDisplayed = webElement.isDisplayed();
            logger.info("Element is displayed " + isDisplayed);
            return isDisplayed;
        }catch (Exception e){
            logger.info("Element is displayed -> false");
            return false;
        }
    }


    public void selectTextInDropdown(WebElement element, String text){
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info("Text " + text + " was selected in dropdown " + element);

        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }


    //TODO:
    public void selectValue(WebElement element, String value){
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info("Value " + value + " was selected in dropdown" );

        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }
}
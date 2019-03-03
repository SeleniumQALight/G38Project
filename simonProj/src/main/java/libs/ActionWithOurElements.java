package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionWithOurElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;

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


    public void clickOnElement(WebElement element) {
        try {
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

}

package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(ActionsWithElements.class); //инициализировали логер
    WebDriverWait wait10, wait15;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait10 = new WebDriverWait(webDriver,10);
        wait15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info( text + " was input into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    /**
     * Stop test and print ERROR
     * @param e
     */
    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    public void clickOnElement(WebElement element) {
        try{
            wait10.until(ExpectedConditions.elementToBeClickable(element)); //ждет, пока элемент не станет кликабельным
//            wait10.until(ExpectedConditions.not(                            //not sintaxis example
//                    ExpectedConditions.elementToBeClickable(element)
//            ));
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element is displayed -> " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.info("Element is displayed -> false + "+ e);
            return false;
        }
    }

    public boolean isElementDisplayed(By xpath) {
        try{
            return isElementDisplayed(webDriver.findElement(xpath));
        } catch (Exception e){
            return false;
        }
    }

    public void selectTextInDropDown(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in drop-down");
        } catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDropDown(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in drop-down");
        } catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    /**
     * Set status for checkbox can be "IsDisable", "dropDownIsSelected", "dropDownIsNotSelected"
     * @param webElement
     * @return
     */
    public String setStatusToCheckBox(WebElement webElement) {
        boolean isElementEnable = webElement.isEnabled();
        boolean isDropDownSelected = webElement.isSelected();

        if (isElementEnable == true && isDropDownSelected == false) {
            return "dropDownIsNotTicked";
        } else if (isElementEnable == true && isDropDownSelected == true) {
            return "dropDownIsTicked";
        } else {
            return "IsDisable";
        }
    }

    public void clickOnCheckbox(WebElement webElement, String expectedStatus) {
        String checkBoxStatus = setStatusToCheckBox(webElement);
        if( expectedStatus == "IsDisable" && expectedStatus == checkBoxStatus) {
            logger.info("checkbox is desable");
        }
        else if (expectedStatus == "IsDisable" && expectedStatus != checkBoxStatus) {
            Assert.fail("Expected status = " + expectedStatus + " but checkbox status = " + checkBoxStatus);
        }

        else if (expectedStatus == checkBoxStatus) {
            webElement.click();
        }
        else if(expectedStatus != checkBoxStatus) {
        }
    }

    public void dropDown(WebElement dropDown, WebElement value) {
        try {
            clickOnElement(dropDown);
            clickOnElement(value);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(By xpath) {
        try{
            clickOnElement(webDriver.findElement(xpath));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    /**
     * set check box status [neededState] can be only "check" or "uncheck"
     * @param element
     * @param neededState can be "check" or "uncheck"
     */
    public void setStatusToCheckBox(WebElement element, String neededState) {
        if("check".equals(neededState) || "uncheck".equals(neededState)) {
            try{

                if(element.isSelected() && "check".equals(neededState)) {
                    logger.info("Already checked");

                }else if(!element.isSelected() && "check".equals(neededState)) {
                    element.click();
                    logger.info("check box checked");
                }else if (element.isSelected() && "uncheck".equals(neededState)) {
                    element.click();
                    logger.info("Check box was selected");
                } else if(!element.isSelected() && "uncheck".equals(neededState)){
                    logger.info("Already unchecked");
                }

            } catch (Exception e) {
                printErrorAndStopTest(e);
            }
        } else {
            logger.error("checkbox state should be check or uncheck");
            Assert.fail("[Assert.fail] : checkbox state should be check or uncheck");
        }
    }
}
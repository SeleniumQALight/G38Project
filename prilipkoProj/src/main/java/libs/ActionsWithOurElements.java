package libs;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ActionsWithOurElements {

    WebDriver driver;
    private Logger logger = Logger.getLogger(getClass());

    public ActionsWithOurElements(WebDriver driver) {
        this.driver = driver;
    }
// *********************************************************************************************************************
    public void enterTextInToElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was input into element"); //Просто информация
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Button Submit was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
// *********************************************************************************************************************
    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element " + e); //Вывод ошибки
        Assert.fail("Cannot work with element " + e);
    }
}
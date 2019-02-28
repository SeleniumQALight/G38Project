package libs;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


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

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Button Submit was clicked");
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

    // TODO. Работа с селектами. Добавить метод для эмуляции действия пользователя, и по видимому тексту в селекте.
    public void selectValueInDropown(WebElement webElement, String value) {
        try {
            Select select = new Select(webElement);
            select.selectByValue(value);
            logger.info(value + " is selected in drop-down");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    // TODO. Работа с Чекбоксами. Дома сделать.
    public void checkbox(WebElement webElement, String value) {

    }
// *********************************************************************************************************************
    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element " + e); //Вывод ошибки
        Assert.fail("Cannot work with element " + e);
    }
}
package pages;


import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ParentPage {

    WebDriver driver;

    protected LoginPage loginPage;
    protected ActionsWithOurElements actionsWithOurElements;

    Logger logger = Logger.getLogger(getClass());

    public ParentPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver,this); // Создали объекты WebElement

        actionsWithOurElements = new ActionsWithOurElements(driver);
    }
}
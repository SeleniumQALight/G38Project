package pages;


import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ParentPage {

    WebDriver driver;

    protected LoginPage loginPage;
    protected ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver,this); // Создали объекты WebElement

        actionsWithOurElements = new ActionsWithOurElements(driver);
    }
}
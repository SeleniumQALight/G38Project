package pages;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PerentPage {
    WebDriver webDriver;
    ActionsWithOurElements actionsWithOurElements;
    public PerentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements=new ActionsWithOurElements(webDriver);
    }
}

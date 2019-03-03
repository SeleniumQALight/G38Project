package pages;

import libs.ActionWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    WebDriver webDriver;
    ActionWithOurElements actionWithOurElements;
    Logger logger = Logger.getLogger(getClass());


    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);

        actionWithOurElements = new ActionWithOurElements(webDriver);


    }
}

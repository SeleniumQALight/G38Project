package pages;

import libs.ActionsWithElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    WebDriver webDriver;
    ActionsWithElements actionsWithElements;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); // Создали объект  WebElement (инициализируем все элементы описанные в FindBy)
        actionsWithElements = new ActionsWithElements(webDriver); // инициализировал actions with elements
    }


}

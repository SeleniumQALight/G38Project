package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class ParentPage {
    WebDriver webDriver; // 1. Обьявляем
    // 3. обьявили переменную  ПЕРЕНТ ТЕСТ и добавили loginPage = new LoginPage( webDriver); - что значит что именно в
    // этом браузере
    ActionsWithOurElements actionsWithOurElements;

    Logger logger = Logger.getLogger(getClass());

    public ParentPage(WebDriver webDriver) { // 2. ПКМ - Дженерейт - конструктор и дальше дем в пейдж,
        // добавляем наслндование от этой
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }


}

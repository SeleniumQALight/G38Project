package pages;

import org.openqa.selenium.WebDriver;

public class ParentPage {
    WebDriver webDriver; // 1. Обьявляем
    // 3. обьявили переменную  ПЕРЕНТ ТЕСТ и добавили loginPage = new LoginPage( webDriver); - что значит что именно в
    // этом браузере



    public ParentPage(WebDriver webDriver) { // 2. ПКМ - Дженерейт - конструктор и дальше дем в пейдж,
        // добавляем наслндование от этой
        this.webDriver = webDriver;
    }
}

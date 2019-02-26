package pages;


import org.openqa.selenium.WebDriver;


public class ParentPage {

    WebDriver driver;
    protected LoginPage loginPage;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
    }
}
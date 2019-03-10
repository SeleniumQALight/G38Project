package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EditSparePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    WebDriver webDriver; // 4. Обья вили вебдрайвер перед Бефор и Автер, чтоб он был доступен для каждого метода (внутренность бефор и афтер_
    protected LoginPage loginPage; // 5.
    protected HomePage homePage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;


    @Before // 1. Добавляем наследование из джейюнита - означает, что за этим методом отдельный тест кейс.
    // Что после обьявления будет тест кейс
    public  void setUp () { // 2. Добавляем метод (и аналогчно для Афтер
        File file = new File("./src/drivers/chromedriver.exe"); //3.2.
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());  //3.4.

        webDriver = new ChromeDriver(); // 3.1.- создаем обьект хрома который будет обращаться к файлу ехе

        webDriver.manage().window().maximize(); // 3.2. обращаемся у менеджеру веб брукзера, говорим открой окно и максимайз - на весь екран
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//
        loginPage = new LoginPage( webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);
    }

    protected void checkExpectedResult (String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult); // actual Result - what we send to this method
        //and compare this result with true value. and message displays if test failed

    }
    @After
    public void tearDown () {
        webDriver.quit ();

    }


}

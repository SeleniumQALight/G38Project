package parentTest;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SpareEditPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    WebDriver webDriver; // 4. Обья вили вебдрайвер перед Бефор и Автер, чтоб он был доступен для каждого метода (внутренность бефор и афтер_

    protected static ConfigProperties configProperties
            = ConfigFactory.create(ConfigProperties.class);
    // we created an object that will be go to file and take data from them
    // we say - create value from that data

    Logger logger = Logger.getLogger(getClass());

    protected LoginPage loginPage; // 5.
    protected HomePage homePage;
    protected SparePage sparePage;
    protected SpareEditPage spareEditPage;


    @Before // 1. Добавляем наследование из джейюнита - означает, что за этим методом отдельный тест кейс.
    // Что после обьявления будет тест кейс
    public void setUp() { // 2. Добавляем метод (и аналогчно для Афтер
        File file = new File("./src/drivers/chromedriver.exe"); //3.2.
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());  //3.4.

        webDriver = new ChromeDriver(); // 3.1.- создаем обьект хрома который будет обращаться к файлу ехе

        webDriver.manage().window().maximize(); // 3.2. обращаемся у менеджеру веб брукзера, говорим открой окно и максимайз - на весь екран
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        spareEditPage = new SpareEditPage(webDriver);

    }

    @Step
    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult); // actual Result - what we send to this method
        //and compare this result with true value. and message displays if test failed

    }

    @After
    public void tearDown() {
    //    webDriver.quit();

    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        String fileName;

        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }

        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }

        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };
}

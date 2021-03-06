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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;
// -Dbrowser=firefox
public class ParentTest {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;
    protected ServicePage servicePage;
    protected EditServicePage editServicePage;

    private final Logger log = Logger.getLogger(this.getClass());


    String browser = System.getProperty("browser");


    @Before
    public void before() {


        initDriver(); // раньше код с initDriver был тут

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);
        servicePage = new ServicePage(webDriver);
        editServicePage = new EditServicePage(webDriver);
    }


    @After
    public void after() {
        webDriver.quit();
    }

    @Step
    protected void checkExpectedResult(String massage, boolean actualResult) {
        Assert.assertEquals(massage, actualResult, true);
    }


    private void initDriver() {

        if (browser == null || "chrome".equals(browser.toLowerCase())) {                // CHROME

            File file = new File("./src/drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

            webDriver = new ChromeDriver();


        }
        else if ("firefox".equals(browser)) {                                           // FIREFOX
            File file = new File("./src/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_override.mstone"
                    , "ignore"); // Suppress the "What's new" page

            webDriver = new FirefoxDriver();


        }
//            else if ("iedriver".equals(browser)) {
//            log.info("IE will be started");
//            File file1 = new File("./src/drivers/IEDriverServer.exe");
//            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
//            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//            capabilities.setCapability("ignoreZoomSetting", true);
//            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            webDriver = new InternetExplorerDriver();
//            log.info(" IE is started");
//        }


    }



    @Rule // add screenshoting to allure
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

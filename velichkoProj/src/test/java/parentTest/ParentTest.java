package parentTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.EditSparePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;

import java.io.File;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected static ConfigProperties  configProperties
            = ConfigFactory.create(ConfigProperties.class);
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    protected EditSparePage editSparePage;
    String browser = System.getProperty("browser");

    @Before
    public void setUp() {
        initDriver();


        //ChromeDriverManager.getInstance().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("window-size=1920,1080");
        //DesiredCapabilities cap = DesiredCapabilities.chrome();
        //cap.setCapability(ChromeOptions.CAPABILITY, options);
        //webDriver = new ChromeDriver(cap);


        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        editSparePage = new EditSparePage(webDriver);


    }

    @After
    public void tearDown() {

        webDriver.quit();

    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);

    }

    private void initDriver() {
        if (browser == null || "chrome".equals(browser.toLowerCase())) {

            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();

        }else if ("firefox".equals(browser)){
            File file = new File("./src/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_override.mstone"
                    , "ignore"); // Suppress the "What's new" page


            webDriver = new FirefoxDriver();
        }

    }
}
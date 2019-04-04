package parentTest;


import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.DashboardPage;
import pages.LoginPage;
import pages.dictionary.apparatPage.ApparatEditPage;
import pages.dictionary.apparatPage.ApparatPage;
import pages.dictionary.providersPage.ProvidersEditPage;
import pages.dictionary.providersPage.ProvidersPage;
import pages.dictionary.sparesPage.SparesEditPage;
import pages.dictionary.sparesPage.SparesPage;
import pages.dictionary.workersPage.WorkersEditPage;
import pages.dictionary.workersPage.WorkersPage;
import pages.installationPage.InstallationEditPage;
import pages.installationPage.InstallationPage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class ParentTest {

    private WebDriver driver;
    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    private Logger logger = Logger.getLogger(getClass());

    protected Date dateNow = new Date();
    protected SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy/MM/dd_hh:mm:ss");

    protected LoginPage loginPage;
    protected DashboardPage homePage;
    protected ApparatPage apparatPage;
    protected ApparatEditPage apparatEditPage;
    protected WorkersPage workersPage;
    protected WorkersEditPage workersEditPage;
    protected SparesPage sparesPage;
    protected SparesEditPage sparesEditPage;
    protected ProvidersPage providersPage;
    protected ProvidersEditPage providersEditPage;
    protected InstallationPage installationPage;
    protected InstallationEditPage installationEditPage;

    String browser = System.getProperty("browser");

    protected String LOGIN = "Student";
    protected String PASSWORD = "909090";

    @Before
    public void setUp() {

        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homePage = new DashboardPage(driver);
        apparatPage = new ApparatPage(driver);
        apparatEditPage = new ApparatEditPage(driver);
        workersPage = new WorkersPage(driver);
        workersEditPage = new WorkersEditPage(driver);
        sparesPage = new SparesPage(driver);
        sparesEditPage = new SparesEditPage(driver);
        providersPage = new ProvidersPage(driver);
        providersEditPage = new ProvidersEditPage(driver);
        installationPage = new InstallationPage(driver);
        installationEditPage = new InstallationEditPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message,true,actualResult);
    }

    private void initDriver() {
        if (browser == null || "chrome".equals(browser.toLowerCase())) {
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            File file = new File("./src/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore");
            driver = new FirefoxDriver();
        } else if ("iedriver".equals(browser)) {
            logger.info("IE will be started");
            File file1 = new File("./src/drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new InternetExplorerDriver();
            logger.info("IE is started");
        }
    }
}
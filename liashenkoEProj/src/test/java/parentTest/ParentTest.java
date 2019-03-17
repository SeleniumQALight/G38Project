package parentTest;

import mainPack.pages.HomePage;
import mainPack.loginPage.LoginPages;
import mainPack.pages.SettingPage;
import mainPack.pages.VocabularyPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LoginPages loginPages;
    protected HomePage homePage;
    protected SettingPage settingPage;
    protected VocabularyPage vocabularyPage;
    String browser = System.getProperty("browser");

    @Before
    public void setUp() {
        initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPages = new LoginPages(webDriver);
        homePage = new HomePage(webDriver);
        settingPage = new SettingPage(webDriver);
        vocabularyPage = new VocabularyPage(webDriver);
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
        } else if ("firefox".equals(browser)) {
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

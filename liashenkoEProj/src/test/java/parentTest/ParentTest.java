package parentTest;

import mainPack.pages.HomePage;
import mainPack.pages.LoginPages;
import mainPack.pages.SettingPage;
import mainPack.pages.VocabularyPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LoginPages loginPages;
    protected HomePage homePage;
    protected SettingPage settingPage;
    protected VocabularyPage vocabularyPage;

    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPages = new LoginPages(webDriver);
        homePage = new HomePage(webDriver);
        settingPage = new SettingPage(webDriver);
        vocabularyPage = new VocabularyPage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
    protected void checkExpectedResult(String message, boolean actualResult){
        Assert.assertEquals(message, true, actualResult);

    }
}

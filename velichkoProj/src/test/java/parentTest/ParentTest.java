package parentTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Before
    public void setUp(){

        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        //ChromeDriverManager.getInstance().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("window-size=1920,1080");
        //DesiredCapabilities cap = DesiredCapabilities.chrome();
       // cap.setCapability(ChromeOptions.CAPABILITY, options);
       WebDriver driver = new ChromeDriver();


//         webDriver = new ChromeDriver(cap);

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);

    }
    @After
    public void tearDown(){

        webDriver.quit();

    }

    protected void checkExpectedResult(String message, boolean actualResult){
        Assert.assertEquals(message, true, actualResult);

    }

}

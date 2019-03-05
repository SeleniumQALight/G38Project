package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver = new ChromeDriver();
    protected LoginPage loginPage = new LoginPage(webDriver);
    protected HomePage homePage= new HomePage(webDriver);
//
    @Before
    public void setUp() {
//        File file = new File("./src/drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

//        webDriver = new ChromeDriver(); // create object for chrome
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 //       loginPage = new LoginPage(webDriver);
 //       homePage = new HomePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkExpectedResult (String message, boolean actualResult){
        Assert.assertEquals(message, true, actualResult); // if actualResult = false, than true<>false -> print message
    }
}

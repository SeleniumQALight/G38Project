package parentTest;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class ParentTest {

    private WebDriver driver;



    protected Date dateNow = new Date();
    protected SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMddhhmmss");

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ApparatPage apparatPage;
    protected ApparatEditPage apparatEditPage;
    protected WorkersPage workersPage;
    protected WorkersEditPage workersEditPage;
    protected ProvidersPage providersPage;
    protected ProvidersEditPage providersEditPage;
    protected InstallationPage installationPage;
    protected InstallationEditPage installationEditPage;

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
        homePage = new HomePage(driver);
        apparatPage = new ApparatPage(driver);
        apparatEditPage = new ApparatEditPage(driver);
        workersPage = new WorkersPage(driver);
        workersEditPage = new WorkersEditPage(driver);
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

    protected void checkExpectedResult(String expectedText, String actualResult) {
        Assert.assertEquals(expectedText,actualResult);
    }
}
package parentTest;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;
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
}
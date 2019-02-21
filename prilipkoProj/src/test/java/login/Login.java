package login;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class Login {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){

        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://v3.test.itpmgroup.com/login");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLogIn() {

        loginPage.inputLogin("Student");
        loginPage.inputPassword("909090");
        DashboardPage dashboardPage = loginPage.clickSubmitButton();
        dashboardPage.assertUserAvatar();

    }

    @Test
    public void loginWithIncorrectPassword() {

        loginPage.inputLogin("Student");
        loginPage.inputPassword("9090");
        loginPage.clickSubmitButton();
        Assert.assertEquals("http://v3.test.itpmgroup.com/login",driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
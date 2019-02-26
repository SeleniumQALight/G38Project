package kP;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class newKP {
    @Test
    public void addData() {
        File file = new File("./src/drivers/geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

        WebDriver webDriver = new FirefoxDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://erdr.gp.gov.ua/erdr/erdr.web.system.LoginPage.cls?AutoLogout=1");
        webDriver.findElement(By.tagName(".//*[@type='button']" )).click();

        System.out.println("Site was opened");

        // webDriver.close();
    }
}



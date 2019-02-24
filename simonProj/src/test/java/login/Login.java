package login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void validLogin() {
        File file = new File("./src/drivers/chromedriver");

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("http://v3.test.itpmgroup.com");

        System.out.print("Site was opened");

        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.name("_password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();
       //  webDriver.findElement(By.className("breadcrumb")).click();
        webDriver.findElement(By.className("navbar-custom-menu")).click();
        webDriver.findElement(By.className("pull-left")).click();
        webDriver.findElement(By.id("userProfileEdit_user_email")).clear();
        webDriver.findElement(By.id("userProfileEdit_user_email")).sendKeys("Test");
      //  webDriver.findElement(By.className("pull-right")).click();
        // webDriver.findElement(By.xpath("//*[contains(text(), 'Copyright © 2016 ')]")).isDisplayed();
        // Assert.assertTrue("Avatar is not present", webDriver.findElement(By.xpath("//*[@class='pull-left image']")).isDisplayed());
        // webDriver.quit();
    }

}

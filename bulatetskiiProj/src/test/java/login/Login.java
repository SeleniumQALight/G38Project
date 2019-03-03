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

            public void velidLogin () {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());


        WebDriver webDrover = new ChromeDriver();

        webDrover.manage().window().maximize();
        webDrover.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDrover.get("http://v3.test.itpmgroup.com");
        System.out.println("Site is open");

        webDrover.findElement(By.name("_username")).sendKeys("Student");
        webDrover.findElement(By.id("password")).sendKeys("909090");
        webDrover.findElement(By.tagName("button")).click();

        Assert.assertTrue("Awatar is not present",webDrover.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());



        webDrover.quit();


    }
}

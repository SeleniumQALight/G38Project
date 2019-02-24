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
    public void validLogin(){

        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("http://v3.test.itpmgroup.com");
        System.out.println("Site was opened");

        webDriver.findElement(By.name("_username")).sendKeys("Student");
        System.out.println("Entered username");
        webDriver.findElement(By.id("password")).sendKeys("909090");
        System.out.println("Entered password");
        webDriver.findElement(By.tagName("button")).click();
        System.out.println("Button clicked");
        Assert.assertTrue("No avatar was displayed", webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());

        webDriver.quit();
    }
}

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
    public void validLogIn() {
        WebDriver webDriver = new ChromeDriver(); // create object for chrome
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webDriver.chrome.driver", file.getAbsolutePath());

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("http://v3.test.itpmgroup.com");
        System.out.println("Site was opened");

        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar is not presented", webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());
        webDriver.quit();
    }
    @Test
    public void inValidLogIn() {
        WebDriver webdriver = new ChromeDriver(); // create object for chrome

//        File file = new File("./src/drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webdriver.get("http://v3.test.itpmgroup.com");
        System.out.println("Site was opened");

        webdriver.findElement(By.name("_username")).sendKeys("Studentka");
        webdriver.findElement(By.id("password")).sendKeys("909090");
        webdriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar is not presented", webdriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());
        webdriver.quit();
    }
}

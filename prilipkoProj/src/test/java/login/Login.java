package login;


import org.junit.Test;
import org.junit.Assert;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {

    @Test
    public void validLogIn() {

        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://v3.test.itpmgroup.com/login");
        driver.findElement(By.xpath(".//input[@placeholder='Email']")).sendKeys("Student");
        driver.findElement(By.xpath(".//input[@type='password']")).sendKeys("909090");
        driver.findElement(By.xpath(".//button[@type='submit']")).click();
        Assert.assertTrue("Avatar is not present",driver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());

        driver.quit();
    }
}
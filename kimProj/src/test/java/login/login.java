package login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class login {

    @Test
    public  void validLogin() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("http://v3.test.itpmgroup.com");

        System.out.println("Site was opened");

        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();
        Assert.assertTrue("Avatar is not displayed", webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());

        webDriver.quit();
    }

    @Test
    /**
     * Home work 19.02.2019
     */
    public void invalidLogin() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println("Start test");
        webDriver.get("http://v3.test.itpmgroup.com");

        webDriver.findElement(By.name("_username")).sendKeys("InvalidName");
        webDriver.findElement(By.id("password")).sendKeys("invalildPass");
        webDriver.findElement(By.tagName("button")).click();
//        Assert.assertFalse("Avatar is not displayed", webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed()); //почему ошибка?
        Assert.assertTrue(" ", webDriver.getCurrentUrl().equals("http://v3.test.itpmgroup.com/login"));

        webDriver.quit();
    }

}

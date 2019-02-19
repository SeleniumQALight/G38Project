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
        WebDriver webdriver = new ChromeDriver(); // create object for chrome
//        File file = new File("./src/drivers/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webdriver.get("http://v3.test.itpmgroup.com");
        System.out.println("Site was opened");

        webdriver.findElement(By.name("_username")).sendKeys("Student");
        webdriver.findElement(By.id("password")).sendKeys("909090");
        webdriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar is not presented", webdriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());
        webdriver.quit();
    }
}

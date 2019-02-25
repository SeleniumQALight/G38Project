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
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();//открой окно маккс
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// таймаут на протяжении 5 сек

        webDriver.get("http://v3.test.itpmgroup.com");

        System.out.println("Site was opened");

        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();
        Assert.assertTrue("Avatar is not present", webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());

    }
    @Test
    public void unValidLogin() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();//открой окно маккс
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// таймаут на протяжении 5 сек

        webDriver.get("http://v3.test.itpmgroup.com");

        System.out.println("Site was opened");

        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.id("password")).sendKeys("90909090");

        try {
            webDriver.findElement(By.tagName("button")).click();
            System.out.println("Button Submit was clicked ");
        }catch (Exception e) {
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element");
  //      Assert.assertFalse("Avatar is not present", webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed());

        }
        webDriver.quit();
}
}

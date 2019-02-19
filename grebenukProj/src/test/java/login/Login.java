package login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Login {
    @Test // 2.
    public void validLogin() {   //3
        File file = new File("./src/drivers/chromedriver.exe"); //4
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());  //5

        WebDriver webDriver = new ChromeDriver(); // 1 - создаем обьект хрома который будет обращаться к файлу ехе

        webDriver.manage().window().maximize(); // 6 обращаемся у менеджеру веб брукзера, говорим открой окно и максимайз - на весь екран
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//  7 это (имплисити вейт) - время неявного ожидания (чтоб все загрузилось) - таймЮнит-Секондс (это время ожижания)
                                                                           // выполнить за секунду и пойдет дальше

       webDriver.get("http://v3.test.itpmgroup.com"); // 8 говорим чтоб открыл нашу юрлу

        webDriver.findElement(By.name("_username")).sendKeys("Student");// 8.1. - кейс сам
        webDriver.findElement(By.id("password")).sendKeys("909090");
        webDriver.findElement(By.tagName("button")).click();

        Assert.assertTrue("Avatar is not present",
                webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed()); // 8.2 ассерт - это проверка от джи юнита. Мы проверяем на тру (должно быть так как мы напишем)
             //8.2. говорим найди элемент по пути (Аватарку) и она должна отобразится

        System.out.println("Site was opened");// 9 sout
        webDriver.quit();//10 закрываем браузер
    }
}
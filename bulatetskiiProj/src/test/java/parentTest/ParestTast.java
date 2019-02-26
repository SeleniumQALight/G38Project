package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParestTast {


   WebDriver webDrover;

    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());


        webDrover = new ChromeDriver();

        webDrover.manage().window().maximize();
        webDrover.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



    }
    @After
    public void tearDown (){

        webDrover.quit();


    }


}

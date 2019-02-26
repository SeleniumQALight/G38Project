package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// HomePage we create in PARENT TEST!!!!!!

public class HomePage extends ParentPage {


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean isAvatarPresent() {
        try {
           return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed(); // написали
            //  найди элемент если ты его нашел и если он показан то верни этот элемент.
            // (ретурн перед методом). А если не нашел, то верни фолс
        } catch (Exception e) {
            return false;
        }

    }
}

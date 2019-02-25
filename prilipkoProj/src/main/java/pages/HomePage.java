package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends ParentPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    private By userAvatar = By.xpath(".//*[@class='pull-left image']");


    public boolean isAvatarPresent() {
        try {
            return driver.findElement(userAvatar).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
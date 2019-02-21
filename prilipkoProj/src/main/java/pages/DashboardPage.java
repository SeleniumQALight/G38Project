package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userMenu = By.xpath(".//li[@class='dropdown user user-menu']");
    private By userAvatar = By.xpath(".//*[@class='pull-left image']");
    private By userName = By.xpath(".//li[@class='dropdown user user-menu']//span");
    private By logoutButton = By.xpath(".//a[@href='/logout']");

    private By mainHeadline = By.xpath("h1");
    private By welcomeMessageText = By.xpath("h3");

    private By dictionaryButton = By.xpath(".//ul/li[@id='dictionary']");
    private By apparatButton = By.xpath(".//ul/li[@id='dictionary']//li[@id='apparat']");
    private By workersButton = By.xpath(".//ul/li[@id='dictionary']//li[@id='workers']");
    private By serviceApparatButton = By.xpath(".//ul/li[@id='service_apparat']");


    public void assertUserAvatar() {
        Assert.assertTrue("Avatar is not present",driver.findElement(userAvatar).isDisplayed());
    }
}
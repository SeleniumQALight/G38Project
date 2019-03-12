package pages;


import libs.ActionsWithOurElements;

import org.apache.log4j.Logger;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ParentPage {

    protected WebDriver driver;
    protected ActionsWithOurElements actionsWithOurElements;

    private Logger logger = Logger.getLogger(getClass());

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        actionsWithOurElements = new ActionsWithOurElements(driver);
    }


    @FindBy(xpath = ".//li[@id='dashboard']//span")
    private WebElement dashboardButton;

    @FindBy(xpath = ".//li[@id='dictionary']//span")
    private WebElement dictionaryButton;

    @FindBy(xpath = ".//li[@id='apparat']/a")
    private WebElement apparatButton;

    @FindBy(xpath = ".//li[@id='workers']/a")
    private WebElement workersButton;

    @FindBy(xpath = ".//li[@id='spareType']/a")
    private WebElement spareTypeButton;

    @FindBy(xpath = ".//li[@id='spares']/a")
    private WebElement sparesButton;

    @FindBy(xpath = "//li[@id='prov_cus']/a")
    private WebElement providersButton;

    @FindBy(xpath = "//li[@id='deal_type']/a")
    private WebElement dealTypeButton;

    @FindBy(xpath = ".//li[@id='service_apparat']//span")
    private WebElement serviceButton;

    @FindBy(xpath = ".//li[@id='installation']//span")
    private WebElement installationButton;

    @FindBy(xpath = ".//li[@id='deal']//span")
    private WebElement dealButton;

    @FindBy(xpath = ".//li[@id='report']//span")
    private WebElement statisticButton;


    public void openPage() {
        try {
            driver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Cannot open login page" + e);
            Assert.fail("Cannot open login page" + e);
        }
    }

    public void clickOnDashboardMenu() {
        actionsWithOurElements.clickOnElement(dashboardButton);
    }

    public void clickOnDictionaryMenu() {
        actionsWithOurElements.clickOnElement(dictionaryButton);
    }

    public void clickOnSubMenuApparat() {
        actionsWithOurElements.clickOnElement(apparatButton);
    }

    public void clickOnSubMenuWorkers() {
        actionsWithOurElements.clickOnElement(workersButton);
    }

    public void clickOnSubMenuSpareType() {
        actionsWithOurElements.clickOnElement(spareTypeButton);
    }

    public void clickOnSubMenuSpares() {
        actionsWithOurElements.clickOnElement(sparesButton);
    }

    public void clickOnSubMenuProviders() {
        actionsWithOurElements.clickOnElement(providersButton);
    }

    public void clickOnSubMenuDealType() {
        actionsWithOurElements.clickOnElement(dealTypeButton);
    }

    public void clickOnServiceMenu() {
        actionsWithOurElements.clickOnElement(serviceButton);
    }

    public void clickOnInstallationMenu() {
        actionsWithOurElements.clickOnElement(installationButton);
    }

    public void clickOnDealMenu() {
        actionsWithOurElements.clickOnElement(dealButton);
    }

    public void clickOnStatisticMenu() {
        actionsWithOurElements.clickOnElement(statisticButton);
    }
}
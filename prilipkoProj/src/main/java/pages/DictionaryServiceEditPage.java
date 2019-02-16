package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DictionaryServiceEditPage {

    private WebDriver driver;

    public DictionaryServiceEditPage(WebDriver driver) {
        this.driver = driver;
    }

    By serviceChangesField = By.xpath(".//input[@id='service_apparat_serviceChanges']");
    By serviceOperationsField = By.xpath(".//input[@id='service_apparat_serviceOperations']");
    By serviceDateDaySelect = By.xpath(".//select[@id='service_apparat_serviceDate_date_day']");
    By serviceDateMonthSelect = By.xpath(".//select[@id='service_apparat_serviceDate_date_month']");
    By serviceDateYearSelect = By.xpath(".//select[@id='service_apparat_serviceDate_date_year']");
    By serviceDateTimeHourSelect = By.xpath(".//select[@id='service_apparat_serviceDate_time_hour']");
    By serviceDateTimeMinuteSelect = By.xpath(".//select[@id='service_apparat_serviceDate_time_minute']");
    By serviceApparatSelect = By.xpath(".//select[@id='service_apparat_apparat']");
    By serviceApparatWorkerSelect = By.xpath(".//select[@id='service_apparat_worker']");
    By createButton = By.xpath(".//button[@type='submit']");
}
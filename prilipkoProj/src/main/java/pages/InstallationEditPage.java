package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InstallationEditPage extends ParentPage {

    public InstallationEditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//select[@id='installation_installationDate_date_day']")
    private WebElement installationDaySelect;

    @FindBy(xpath = ".//select[@id='installation_installationDate_date_month']")
    private WebElement installationMonthSelect;

    @FindBy(xpath = ".//select[@id='installation_installationDate_date_year']")
    private WebElement installationYearSelect;

    @FindBy(xpath = ".//select[@id='installation_installationDate_time_hour']")
    private WebElement installationTimeHourSelect;

    @FindBy(xpath = ".//select[@id='installation_installationDate_time_minute']")
    private WebElement installationTimeMinuteSelect;

    @FindBy(xpath = ".//select[@id='installation_apparat']")
    private WebElement installationApparatSelect;

    @FindBy(xpath = ".//select[@id='installation_worker']")
    private WebElement workerSelect;


    public void selectInstalattionDate(String day, String month, String year, String hour, String minute) {
        actionsWithOurElements.selectValueInDropdown(installationDaySelect, day);
        actionsWithOurElements.selectValueInDropdown(installationMonthSelect, month);
        actionsWithOurElements.selectValueInDropdown(installationYearSelect, year);
        actionsWithOurElements.selectValueInDropdown(installationTimeHourSelect, hour);
        actionsWithOurElements.selectValueInDropdown(installationTimeMinuteSelect, minute);
    }

    public void selectInstallationApparat(String apparat) {
        actionsWithOurElements.selectVisibleTextInDropdown(installationApparatSelect, apparat);
    }

    public void selectWorker(String text) {
        actionsWithOurElements.selectTextInDropdownByUi(workerSelect,text);
    }
}
package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicePage extends ParentPage {


    @FindBy(xpath = "/html/body/div/div/section[2]/div/div/div/div[1]/div/a")
    private WebElement addButton;




    public ServicePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickOnAddButton(){

        actionsWithOurElements.clickOnElement(addButton);
    }


    public boolean isServiceInList(String serviceName) {
        return actionsWithOurElements.isElementPresent(By.xpath(".//*[text()='" + serviceName + "']"));

    }

    public void deletingServiceUntilPresent(String serviceName) {

        int counter = 0;

        EditServicePage editServicePage = new EditServicePage(webDriver);
        while (isServiceInList(serviceName)){

            clickOnService(serviceName);
            editServicePage.clickOnButtonDelete();
            counter++;

            if (counter > 100){
                Assert.fail("There are more than 100 services");
            }
        }
    }

    private void clickOnService(String serviceName) {
        actionsWithOurElements.clickOnElement(By.xpath(".//*[text()='" + serviceName + "']"));

    }
}

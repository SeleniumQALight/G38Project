package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends ParentPage {

    @FindBy(className = "box-tools")
//    @FindBy(xpath = "//*[@class='fa fa-plus']") //предложено на уроке
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickOnAddButton() {
        actionsWithElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName) {
        return actionsWithElements
                .isElementDisplayed(By.xpath(".//*[text()='"+spareName+"']"));
    }
}

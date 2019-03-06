package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ApparatEditPage extends ParentPage {

    public ApparatEditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@id='apparat_apparatNumber']")
    private WebElement apparatNumberField;

    @FindBy(xpath = ".//input[@id='apparat_apparatComment']")
    private WebElement apparatCommentField;


    public void inputApparatNumber(String text) {
        actionsWithOurElements.enterTextInToElement(apparatNumberField, text);
    }

    public void inputApparatComment(String text) {
        actionsWithOurElements.enterTextInToElement(apparatCommentField, text);
    }

    public String getApparatComment() {
        return apparatCommentField.getAttribute("value");
    }
}
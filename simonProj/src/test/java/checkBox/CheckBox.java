package checkBox;

import libs.ActionWithOurElements;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import parenttest.Parenttest;

public class CheckBox extends Parenttest {

    WebDriver webDriver;

    @Test
    public void CheckBoxMyFirstTest() {

        loginPage.openPage();
        loginPage.enterTextInToInputLogin("Student");
        loginPage.enterTextInToInputPass("909090");
        loginPage.clickOnButtonSubmit();
        dictionaryPage.menuClickDictionary();
        dictionaryPage.setMenuDictionaryDeals();
        dictionaryPage.findMyCardWithCheckBoxes();
        dictionaryPage.setValueInCheckBoxPrivatPerson();
        dictionaryPage.setValueInCheckBoxIsOurFirm();

    }

}

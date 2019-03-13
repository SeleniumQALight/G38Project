package setting;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

public class SettingWithPageObject extends ParentTest {

    @Test
    public void addSetting(){
        loginPages.login("Student", "909090");
        loginPages.clickOnSettingButton();
        settingPage.clickOnButtonAddSetting();
        vocabularyPage.selectDate();
        vocabularyPage.clickOnFildAparat();
        vocabularyPage.selectAparat();
        vocabularyPage.clickOnFildEmployee();
        vocabularyPage.selectEmployee();
        vocabularyPage.clickOnButtonCreat();

        checkExpectedResult(
                "Element is not present",
                settingPage.elementCraeted());
    }

    @Test
    public void removeSetting(){
        loginPages.login("Student", "909090");
        loginPages.clickOnSettingButton();
        settingPage.selectElement();
        vocabularyPage.clickOnButtonDelete();

        checkExpectedResult(
               "Element present",
                !settingPage.elementCraeted());
    }

    @Test
    public void addPartToPartsList(){
        loginPages.login("Student", "909090");
        loginPages.clickOnSettingButton();
        settingPage.selectElement();
        vocabularyPage.clickOnButtonAddPart();
        vocabularyPage.workWithCheckBox("check");
        vocabularyPage.enterTextToInputSpareCount("123456");
        vocabularyPage.selectSetting();
        vocabularyPage.selectPart();
        vocabularyPage.clickOnButtonCreat();


    }
}


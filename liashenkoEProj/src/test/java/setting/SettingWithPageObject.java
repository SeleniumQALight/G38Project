package setting;

import org.junit.Test;
import parentTest.ParentTest;

public class SettingWithPageObject extends ParentTest {

    @Test
    public void addSetting(){
        loginPages.login("Student", "909090");
        loginPages.clickOnSettingButton();
        settingPage.clickOnButtonAddSetting();
        vocabularyPage.selectDateDay();
        vocabularyPage.clickOnFildAparat();
        vocabularyPage.selectAparat();
        vocabularyPage.clickOnFildEmployee();
        vocabularyPage.selectEmployee();
        vocabularyPage.clickOnButtonCreat();

        checkExpectedResult(
                "Element is not present",
                settingPage.elementCraeted());



    }
}


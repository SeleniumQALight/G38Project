package setting;

import org.junit.Test;
import parentTest.ParentTest;

public class SettingWithPageObject extends ParentTest {

    @Test
    public void addSetting() throws InterruptedException{
        loginPages.login("Student", "909090");
        loginPages.clickOnSettingButton();
        Thread.sleep(1000);
        settingPage.clickOnButtonAddSetting();
       // settingPage.clickOnFildAparat();
        //Thread.sleep(1000);


    }
}


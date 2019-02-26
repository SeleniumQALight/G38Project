package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    WebDriver webDriver;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            System.out.println("Login page was opened");
        }catch (Exception e){
            System.out.println("Can not open Login page" + e);
            Assert.fail("Can not open Login page" + e);
        }
    }
    // чтобы работать без логина
//    public void openPage(String url) {
//        try {
////            webDriver.get("http://v3.test.itpmgroup.com");
//            webDriver.get(url);
//            System.out.println("Login page was opened");
//        }catch (Exception e){
//            System.out.println("Can not open Login page" + e);
//            Assert.fail("Can not open Login page" + e);
//        }
//    }
}

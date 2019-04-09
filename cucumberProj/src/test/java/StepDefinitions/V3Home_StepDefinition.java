package StepDefinitions;

import Selenium.SeleniumFunctions;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class V3Home_StepDefinition {
    HomePage homePage = new HomePage(SeleniumFunctions.driver);

    @Then("^user sees avatar on Home Page$")
    public void user_sees_avatar_on_Home_Page() throws Throwable {
        Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());
    }


}

package siutes;


import login.LoginWithExelData;
import login.LoginWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObject.class,
                LoginWithExelData.class
        }
)
public class SmokeSuite {
}

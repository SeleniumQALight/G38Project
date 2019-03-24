package siutes;

import login.LoginWithPageObject1;
import login.LoginWithParams;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithParams.class,
                LoginWithPageObject1.class
        }
)
public class SmokeSuite {

}

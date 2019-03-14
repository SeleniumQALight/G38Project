package suites;

import login.Login;
import login.LoginWithPageObject;
import login.LoginWithParams;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObject.class,
                LoginWithParams.class
        }
)

public class SmokeSuite {

}

package suites;


import login.LoginWithPageObject;
import login.LoginWithParam;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObject.class,
                LoginWithParam.class
        }
)

public class SmokeSuite {

}
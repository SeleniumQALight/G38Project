package suits;


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
public class SmokeSuit {
}

package suits;


import login.LoginWithPageObject;
import login.LoginWithParameters;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses (
        {
                LoginWithPageObject.class,
                LoginWithParameters.class
        }
)
public class SmokeSuit {

}

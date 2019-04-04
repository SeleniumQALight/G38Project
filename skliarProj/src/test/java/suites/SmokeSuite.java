package suites;

import login.LoginWithPageObject;
import login.LoginsWithParams;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sparSpare.AddNewSpare;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObject.class,
//                LoginsWithParams.class,
//                AddNewSpare.class
        }
)
public class SmokeSuite {

}

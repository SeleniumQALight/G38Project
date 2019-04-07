package siutes;


import login.LoginWithDataFromExcel;
import login.LoginWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObject.class,
                LoginWithDataFromExcel.class
        }
)
public class SmokeSuite {
}

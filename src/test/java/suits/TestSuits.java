package suits;


import TestCases.Homepage;
import TestCases.SecondPage;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Homepage.class,
        SecondPage.class
})

public class TestSuits {
}

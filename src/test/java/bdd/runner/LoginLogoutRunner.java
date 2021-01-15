package bdd.runner;


import bdd.base.Base;
import com.bdd.ExtentReporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/LoginLogout.feature",
        glue = {"bdd/stepdefination"},
        plugin = {"html:dist/cucumber/cucumber-reports-plain.html", "com.bdd.ExtentFormatter:dist/cucumber/cucumber-reports-chart.html"}
)
public class LoginLogoutRunner {

    @AfterClass
    public static void setup() {
        Base.closeOut();
        ExtentReporter.setConfig("src/test/resources/config.xml");
        ExtentReporter.setSystemInfo("Browser", "Chrome");
        ExtentReporter.setSystemInfo("Selenium", "v2.53.1");
    }
}

package bdd.stepdefination;

import bdd.base.Base;
import bdd.pages.Dashboard.Dashboard;
import cucumber.api.PendingException;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginLogoutStepDefs extends Base {
    @Given("^I am logged in as user$")
    public void iAmLoggedInAsUser() {

    }

    @Given("^I am logged in as user by using \"([^\"]*)\"$")
    public void iAmLoggedInAsUserByUsing(String credentials) {
        Dashboard.login(credentials, false);
    }

    @When("^I am in reservation workspace$")
    public void iAmInReservationWorkspace() {
        sleepForAWhile(2000);
        Assert.assertTrue(Dashboard.isElementPresent(By.xpath("//*[@id=\"root\"]/div[1]/header/div/a[1]/span[1]"), "Locations"));

    }

    @Then("^The system allows to me see the user functionality$")
    public void theSystemAllowsToMeSeeTheUserFunctionality() {
    }


    @Then("^The system allows to me see the admin functionality$")
    public void theSystemAllowsToMeSeeTheAdminFunctionality() {
    }


}

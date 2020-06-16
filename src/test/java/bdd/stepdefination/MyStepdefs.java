package bdd.stepdefination;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class MyStepdefs {
    @Given("^I am logged in as gmail$")
    public void iAmLoggedInAsGmail() {
    }

    @When("^I am on Tier (\\d+) Workspace$")
    public void iAmOnTierWorkspace(int arg0) {
    }

    @And("^the System allows to Create New Opportunity$")
    public void theSystemAllowsToCreateNewOpportunity() {
    }
}

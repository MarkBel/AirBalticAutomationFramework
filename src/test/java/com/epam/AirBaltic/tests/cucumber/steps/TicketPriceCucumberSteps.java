package com.epam.AirBaltic.tests.cucumber.steps;

import com.epam.AirBaltic.pages.*;
import com.epam.AirBaltic.tests.PreparationSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by Kate on 12.06.17.
 */
public class TicketPriceCucumberSteps extends PreparationSteps {

    private static final double saleForChildTicket = 0.75;
    private static final int deltaForChildTicket = 2;

    @When("^I go to Book A Flight Form$")
    public void iGoToBookAFlightForm() throws Throwable {
        startPage.goToBookAFlightForm();
    }

    @And("^I fill Book A Flight Form$")
    public void iFillBookAFlightForm() throws Throwable {
        new BookAFlightForm(driver).fillBookAndFlightForm(ORIGIN_AIRPORT, DESTINATION_AIRPORT, DEPARTURE_DATE_DELTA, RETURN_DATE_DELTA);
    }

    @And("^I go to Flights And Ticket Types Page$")
    public void iGoToFlightsAndticketTypesPage() {
        new BookAFlightForm(driver).goToFlightsAndTicketTypesPage();
    }

    @And("^I accept fare$")
    public void iAcceptFare() {
        new FlightsAndTicketTypesPage(driver).acceptFare();
    }

    @And("^I go to Travel Extras Page$")
    public void iGoToTravelExtrasPage() {
        new PassengersPage(driver).goToTravelExtrasPage();
    }

    @Then("^I see Summary Price is Counted Correct$")
    public void iSeeSummaryPriceIsCountedCorrect() {
        Assert.assertTrue(new TravelExtrasPage(driver)
                .isSummaryPriceCountedCorrect(), "Total price doesn't coincides with sum of departure and return prices.");
    }


    @And("^I add a child$")
    public void iAddAChild() throws Throwable {
        new BookAFlightForm(driver).addChild();
    }

    @Then("^I see fare condition is observed$")
    public void iSeeFareConditionIsObserved() throws Throwable {
        Assert.assertTrue(new FlightsAndTicketTypesPage(driver)
                .isFareConditionObserved(saleForChildTicket, deltaForChildTicket), "The condition about child fare towards adult fare is't conformed!");

    }


}

package com.epam.AirBaltic.tests.cucumber.steps;

import com.epam.AirBaltic.pages.FlightsAndTicketTypesPage;
import com.epam.AirBaltic.pages.SummaryPage;
import com.epam.AirBaltic.pages.TravelExtrasPage;
import com.epam.AirBaltic.tests.PreparationSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

/**
 * Created by Kate on 13.06.17.
 */
public class TicketReservationCucumberSteps extends PreparationSteps {

    @And("^I go to Passengers Page$")
    public void iGoToPassengersPage() {
        new FlightsAndTicketTypesPage(driver).goToPassengersPage();
    }

    @And("^I go to Summary Page$")
    public void iGoToSummaryPage() {
        new TravelExtrasPage(driver).goToSummaryPage();
    }

    @And("^I choose payment method$")
    public void iChoosePaymentMethod() {
        new SummaryPage(driver).choosePaymentMethod();
    }

    @Then("^I click submit and get error message$")
    public void iClickSubmitAndGettingErrorMessage() {
        Assert.assertTrue(new SummaryPage(driver).termsAndConditionsNotAccepted(), "Terms and conditions are accepted");
    }

    @Then("^I choose two seats for one person and see that only one seat can be selected$")
    public void oneSeatForOnePersonCanBeSelected() {
        Assert.assertFalse(new TravelExtrasPage(driver).isTwoSeatsForOnePersonCanBeSelected(), "Two seats are chosen!");
    }


}

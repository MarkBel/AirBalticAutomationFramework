package com.epam.AirBaltic.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Katerina_Karpenia on 3/1/2017.
 */
public class ProcessOfTicketReservationTest extends PreparationSteps {

    @Test
    public void numberOfChosenSeatsForOnePersonTest()  {
        Assert.assertFalse(startPage
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .getLoginStatement()
                .goToBookAFlightForm()
                .fillBookAndFlightForm(ORIGIN_AIRPORT, DESTINATION_AIRPORT, DEPARTURE_DATE_DELTA, RETURN_DATE_DELTA)
                .goToFlightsAndTicketTypesPage()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .isTwoSeatsForOnePersonCanBeSelected(), "Two seats are chosen!");
    }

    @Test
    public void getErrorIfTermsAndConditionsNotAcceptedTest () {

        Assert.assertTrue(startPage
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .getLoginStatement()
                .goToBookAFlightForm()
                .fillBookAndFlightForm(ORIGIN_AIRPORT, DESTINATION_AIRPORT, DEPARTURE_DATE_DELTA, RETURN_DATE_DELTA)
                .goToFlightsAndTicketTypesPage()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .goToSummaryPage()
                .choosePaymentMethod()
                .termsAndConditionsNotAccepted());
    }

}

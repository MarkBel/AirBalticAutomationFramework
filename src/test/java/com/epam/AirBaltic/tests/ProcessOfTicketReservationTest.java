package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.util.PropertyLoader;
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
                .fillBookAndFlightForm(originAirport,destinationAirport,departureDateDelta,returnDateDelta)
                .goToFlightsAndTicketTypesPage()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .isOneSeatSelected(), "Two seats are chosen!");
    }

    @Test
    public void getErrorIfTermsAndConditionsNotAcceptedTest () {

        Assert.assertTrue(startPage
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .getLoginStatement()
                .goToBookAFlightForm()
                .fillBookAndFlightForm(originAirport,destinationAirport,departureDateDelta,returnDateDelta)
                .goToFlightsAndTicketTypesPage()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .goToSummaryPage()
                .choosePaymentMethod()
                .termsAndConditionsNotAccepted());
    }

}

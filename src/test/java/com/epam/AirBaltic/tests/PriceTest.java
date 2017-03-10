package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.*;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class PriceTest extends PreparationSteps {

    private BookAFlightForm flightPage;
    private FlightsAndTicketTypesPage farePage;

    @Test
    public void totalPriceConsistOfDeparturePriceAndReturnPriceTest() {
        Assert.assertTrue(startPage.goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .getLoginStatement()
                .goToBookAFlightForm()
                .fillBookAndFlightForm(originAirport, destinationAirport, departureDateDelta, returnDateDelta)
                .goToFlightsAndTicketTypesPage()
                .acceptFare()
                .goToTravelExtrasPage()
                .checkSummaryPrice(), "Total price doesn't coincides with sum of departure and return prices.");
    }

    @Test
    public void childTicketIs25PercentLessThanAdult( ) {
        Assert.assertTrue(startPage
                .goToBookAFlightForm()
                .fillBookAndFlightForm(originAirport, destinationAirport, departureDateDelta, returnDateDelta)
                .addChild()
                .goToFlightsAndTicketTypesPage()
                .checkFareCondition(), "The condition about child fare towards adult fare is't conformed!");
    }
}

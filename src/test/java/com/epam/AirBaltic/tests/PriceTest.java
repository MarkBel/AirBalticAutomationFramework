package com.epam.AirBaltic.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class PriceTest extends PreparationSteps {

   private static final double saleForChildTicket = 0.75;
   private static final int deltaForChildTicket = 2;


    @Test
    public void totalPriceConsistOfDeparturePriceAndReturnPriceTest() {
        Assert.assertTrue(startPage.goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .getLoginStatement()
                .goToBookAFlightForm()
                .fillBookAndFlightForm(ORIGIN_AIRPORT, DESTINATION_AIRPORT, DEPARTURE_DATE_DELTA, RETURN_DATE_DELTA)
                .goToFlightsAndTicketTypesPage()
                .acceptFare()
                .goToTravelExtrasPage()
                .checkSummaryPrice(), "Total price doesn't coincides with sum of departure and return prices.");
    }

    @Test
    public void childTicketIs25PercentLessThanAdult() {
        Assert.assertTrue(startPage
                .goToBookAFlightForm()
                .fillBookAndFlightForm(ORIGIN_AIRPORT, DESTINATION_AIRPORT, DEPARTURE_DATE_DELTA, RETURN_DATE_DELTA)
                .addChild()
                .goToFlightsAndTicketTypesPage()
                .isFareConditionObserved(saleForChildTicket, deltaForChildTicket), "The condition about child fare towards adult fare is't conformed!");
    }
}

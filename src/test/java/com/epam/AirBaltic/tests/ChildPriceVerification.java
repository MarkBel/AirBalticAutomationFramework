package com.epam.AirBaltic.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class ChildPriceVerification extends PreparationSteps {

    @Test
    public void childPriceTest() {

        Assert.assertTrue(startPage
                .goToBookAFlightForm()
                .fillBookAndFlightForm(originAirport,destinationAirport,departureDateDelta,returnDateDelta)
                .addChild()
                .goToFlightsAndTicketTypesPage()
                .checkFareCondition(), "The condition about child fare towards adult fare is't conformed!");
    }
}

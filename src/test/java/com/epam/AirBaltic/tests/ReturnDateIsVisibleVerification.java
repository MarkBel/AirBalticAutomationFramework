package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mark_Rudak on 3/1/2017.
 */
public class ReturnDateIsVisibleVerification extends PreparationSteps {



    @Test
    public void visabilityOfReturnDateTest() {
        Assert.assertTrue(startPage
                .goToBookAFlightForm()
                .checkOneWayTripAction(originAirport,destinationAirport,RETURN_DATE_ATTRIBUTE), "Visability of Return date is visible!");
    }
}


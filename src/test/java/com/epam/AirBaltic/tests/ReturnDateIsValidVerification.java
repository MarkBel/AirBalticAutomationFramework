package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mark_Rudak on 3/1/2017.
 */
public class ReturnDateIsValidVerification extends PreparationSteps {


    @Test
    public void returnDateIsLessThanDepartureTest() {
        Assert.assertTrue(startPage
                .goToBookAFlightForm()
                .checkReturnDate(originAirport,destinationAirport,returnUnvalidDateDelta,ERROR_MESSAGE),"Return date has an invalid meaning!");
    }

}

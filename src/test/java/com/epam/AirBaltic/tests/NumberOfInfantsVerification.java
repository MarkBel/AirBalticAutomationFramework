package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mark_Rudak on 3/1/2017.
 */
public class NumberOfInfantsVerification extends PreparationSteps {



    @Test
    public void numberOfInfantsTicketsTest()
    {
        Assert.assertTrue(startPage
                .goToBookAFlightForm()
                .checkNumberInfactsTickets(originAirport,destinationAirport,ERROR_INPUT_EXCEPTION),"Number of infants can't be higher than number of adults!");
    }

}

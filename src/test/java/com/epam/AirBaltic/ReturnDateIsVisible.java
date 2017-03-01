package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mark_Rudak on 3/1/2017.
 */
public class ReturnDateIsVisible extends PageTest {

    @Test
    public void visabilityOfReturnDate()


    {
        Assert.assertTrue(new StartPage(driver).openBookAndFlights().checkOneWayTripAction(), "Visability of Return date is visible!");
    }


}


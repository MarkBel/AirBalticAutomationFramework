package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mark_Rudak on 3/1/2017.
 */
public class NumberOfInfantsTest extends AbstractPageTest {

    @Test
    public void numberOfInfantsTickets()
    {
        Assert.assertTrue(new StartPage(driver).goToBookAFlightForm().checkNumberInfactsTickets(),"Number of infants can't be higher than number of adults!");
    }

}

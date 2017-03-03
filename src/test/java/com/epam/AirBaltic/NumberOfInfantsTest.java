package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mark_Rudak on 3/1/2017.
 */
public class NumberOfInfantsTest extends PageTest {

    @Test
    public void NumberOfInfantsTickets()
    {
        Assert.assertTrue(new StartPage(driver).goToBookAFlightForm().checkNumberInfactsTichets(),"Number of infants can't be higher than number of adults!");
    }

}

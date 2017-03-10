package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Mark_Rudak on 3/1/2017.
 */
public class ReturnDateIsValid extends AbstractPageTest {

    @Test
    public void returnDateIsLessThanDeparture() {
        Assert.assertTrue(new StartPage(driver).goToBookAFlightForm().checkReturnDate(),"Return date has an invalid meaning!");
    }

}

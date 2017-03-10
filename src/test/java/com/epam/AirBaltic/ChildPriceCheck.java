package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.BookAFlightForm;
import com.epam.AirBaltic.pages.FlightsAndTicketTypesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class ChildPriceCheck extends AbstractPageTest {

    private static final String WARNING_MASSAGE = "The condition about child fare towards adult fare is't conformed!";

    @Test
    public void childPriceTest() {

        Assert.assertTrue(startPage
                .goToBookAFlightForm()
                .fillBookAndFlightForm()
                .addChild()
                .goToFlightsAndTicketTypesPage()
                .checkFareCondition() , WARNING_MASSAGE);
    }
}

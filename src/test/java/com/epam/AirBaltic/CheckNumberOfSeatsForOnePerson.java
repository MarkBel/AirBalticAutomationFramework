package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.StartPage;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by Davud_Murtazin on 3/2/2017.
 */
public class CheckNumberOfSeatsForOnePerson extends PageTest {

    @Test
    public void testCheckNumberOfSeatsForOnePerson(){
        Assert.assertFalse(new StartPage(driver)
                .goToBookAFlightForm()
                .choseCountryFrom()
                .choseCountryTo()
                .setDepartureDate()
                .setReturnDate()
                .goToFlightsAndTicketTypesPage()
                .goToPassengersPage()
                .enterPassengersData(passenger)
                .goToTravelExstrasPage()
                .isOneSeatSelected());
    }
}

package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.StartPage;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Davud_Murtazin on 3/2/2017.
 */
public class NumberOfSeatsForOnePersonVerification extends PreparationSteps {

    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");



    @Test
    public void numberOfSeatsForOnePersonTest()  {
        Assert.assertFalse(startPage
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .goToBookAFlightForm()
                .fillBookAndFlightForm(originAirport,destinationAirport,departureDateDelta,returnDateDelta)
                .goToFlightsAndTicketTypesPage()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .isOneSeatSelected(), "Two seats are chosen!");
    }
}

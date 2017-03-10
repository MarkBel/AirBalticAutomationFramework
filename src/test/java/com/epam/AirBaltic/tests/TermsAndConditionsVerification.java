package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Katerina_Karpenia on 3/1/2017.
 */
public class TermsAndConditionsVerification extends PreparationSteps {


    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");
    
    @Test
    public void termsAndConditionsTest () {

        Assert.assertTrue(startPage
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .loginCheck()
                .goToBookAFlightForm()
                .fillBookAndFlightForm(originAirport,destinationAirport,departureDateDelta,returnDateDelta)
                .goToFlightsAndTicketTypesPage()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .goToSummaryPage()
                .choosePaymentMethod()
                .checkTermsAndConditions());
    }

}

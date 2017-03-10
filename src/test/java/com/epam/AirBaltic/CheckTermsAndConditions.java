package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.*;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Katerina_Karpenia on 3/1/2017.
 */
public class CheckTermsAndConditions extends AbstractPageTest {

    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");
    
    @Test
    public void checkTermsAndConditionsTest () {

        Assert.assertTrue(startPage
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .loginCheck()
                .goToBookAFlightForm()
                .fillBookAndFlightForm()
                .goToFlightsAndTicketTypesPage()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .goToSummaryPage()
                .choosePaymentMethod()
                .checkTermsAndConditions());
    }

}

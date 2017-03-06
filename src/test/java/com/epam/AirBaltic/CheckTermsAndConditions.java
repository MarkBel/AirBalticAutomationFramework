package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.*;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Katerina_Karpenia on 3/1/2017.
 */
public class CheckTermsAndConditions extends PageTest {

    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");
    
    @Test
    public void checkTermsAndConditionsTest () {

        startPage.loginCheck(USER_NAME, USER_PASSWORD);

        Assert.assertTrue(new StartPage(driver)
                .goToBookAFlightForm()
                .fillBookAndFlightForm()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .goToSummaryPage()
                .choosePaymentMethod()
                .checkTermsAndConditions());


    }

}

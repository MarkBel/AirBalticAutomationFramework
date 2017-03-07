package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.*;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by Katerina_Karpenia on 3/1/2017.
 */
public class CheckTermsAndConditions extends PageTest {

    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");
    
    @Test
    public void checkTermsAndConditionsTest () {

        Assert.assertTrue(new StartPage(driver)
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .loginCheck()
                .goToBookAFlightForm()
                .fillBookAndFlightForm()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .goToSummaryPage()
                .choosePaymentMethod()
                .checkTermsAndConditions());
    }

    @AfterMethod
    public void logout(){
        startPage.logout(START_PAGE_URL);
    }

}

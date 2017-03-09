package com.epam.AirBaltic;

import com.epam.AirBaltic.entity.Passenger;
import com.epam.AirBaltic.pages.StartPage;
import com.epam.AirBaltic.util.PropertyLoader;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Davud_Murtazin on 3/2/2017.
 */
public class CheckNumberOfSeatsForOnePerson extends AbstractPageTest {

    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");


    @Test
    public void testCheckNumberOfSeatsForOnePerson()  {
        Assert.assertFalse(new StartPage(driver)
                .goToLoginForm()
                .login(USER_NAME, USER_PASSWORD)
                .goToBookAFlightForm()
                .fillBookAndFlightForm()
                .goToFlightsAndTicketTypesPage()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .isOneSeatSelected());
    }
}

package com.epam.AirBaltic;

import com.epam.AirBaltic.entity.Passenger;
import com.epam.AirBaltic.pages.StartPage;
import com.epam.AirBaltic.util.PropertyLoader;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Davud_Murtazin on 3/2/2017.
 */
public class CheckNumberOfSeatsForOnePerson extends PageTest {

    protected Passenger passenger;
    private final PropertyLoader properties = new PropertyLoader();

    @BeforeClass
    public void prepareToTest() {
        passenger = new Passenger().loadPassengerDataFromProperties();
    }

    @Test
    public void testCheckNumberOfSeatsForOnePerson() throws InterruptedException {
        Assert.assertFalse(new StartPage(driver)
                .goToLoginForm()
                .login(properties.getProperty("user.name"), properties.getProperty("user.password"))
                .loginCheck()
                .goToBookAFlightForm()
                .fillBookAndFlightForm()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .isOneSeatSelected());
    }
}

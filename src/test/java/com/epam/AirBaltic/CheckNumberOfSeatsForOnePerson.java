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

    @BeforeClass
    public void prepareToTest() {
//        passenger = new Passenger(PropertyLoader.getProperty("passenger.first.name"),
//                PropertyLoader.getProperty("passenger.last.name"),
//                PropertyLoader.getProperty("passenger.tel"),
//                PropertyLoader.getProperty("passenger.email"));
        passenger = new Passenger().loadPassengerDataFromProperties();
    }

    @Test
    public void testCheckNumberOfSeatsForOnePerson(){
        Assert.assertFalse(new StartPage(driver)
                .goToBookAFlightForm()
                .choseCountryFrom()
                .choseCountryTo()
                .setDepartureDate()
                .setReturnDate()
                .continueBooking()
                .goToPassengersPageWithoutAnyActions()
                .enterPassengersData(passenger)
                .goToTravelExstrasPage()
                .isOneSeatSelected());
    }
}

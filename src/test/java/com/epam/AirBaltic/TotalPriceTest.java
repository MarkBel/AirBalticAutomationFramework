package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.*;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalPriceTest extends PageTest {

    private final PropertyLoader properties = new PropertyLoader();
    private final String USERNAME =  properties.getProperty("user.name");
    private final String PASSWORD = properties.getProperty("user.password");
    private BookAFlightForm flightPage;
    private FlightsAndTicketTypesPage farePage;
    private PassengersPage passengersPage;
    private TravelExtrasPage extrasPage;


    @Test
    public void startTest(){
   //     startPage.loginCheck(USERNAME, PASSWORD);
        flightPage = new BookAFlightForm(driver);
        flightPage.fillBookAndFlightForm();
        farePage = new FlightsAndTicketTypesPage(driver);
        passengersPage = farePage.acceptFare();
        extrasPage = passengersPage.goToTravelExtrasPage();
        Assert.assertTrue(extrasPage.checkSummaryPrice(farePage.getDeparturePrice(), farePage.getReturnPrice()));
    }
}

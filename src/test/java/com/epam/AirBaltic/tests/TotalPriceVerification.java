package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.*;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalPriceVerification extends PreparationSteps {

    private final PropertyLoader properties = new PropertyLoader();
    private final String USERNAME =  properties.getProperty("user.name");
    private final String PASSWORD = properties.getProperty("user.password");
    private BookAFlightForm flightPage;
    private FlightsAndTicketTypesPage farePage;
    private PassengersPage passengersPage;
    private TravelExtrasPage extrasPage;
    private LoginForm loginForm;


    @Test
    public void totalPriceTest(){
        loginForm = startPage.goToLoginForm();
        startPage = loginForm.login(USERNAME, PASSWORD);
        startPage.loginCheck();
        flightPage = startPage.goToBookAFlightForm();
        flightPage.fillBookAndFlightForm();
        farePage = flightPage.goToFlightsAndTicketTypesPage();
        passengersPage = farePage.acceptFare();
        extrasPage = passengersPage.goToTravelExtrasPage();
        Assert.assertTrue(extrasPage.checkSummaryPrice(farePage.getDeparturePrice(), farePage.getReturnPrice()));
    }
}

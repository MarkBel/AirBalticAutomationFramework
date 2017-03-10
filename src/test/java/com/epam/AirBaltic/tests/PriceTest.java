package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.*;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class PriceTest extends PreparationSteps {

    private BookAFlightForm flightPage;
    private FlightsAndTicketTypesPage farePage;
    private PassengersPage passengersPage;
    private TravelExtrasPage extrasPage;
    private LoginForm loginForm;

    @Test
    public void totalPriceConsistOfDeparturePriceAndReturnPriceTest(){
        loginForm = startPage.goToLoginForm();
        startPage = loginForm.login(USER_NAME, USER_PASSWORD);
        startPage.getLoginStatement();
        flightPage = startPage.goToBookAFlightForm();
        flightPage.fillBookAndFlightForm(originAirport,destinationAirport,departureDateDelta,returnDateDelta);
        farePage = flightPage.goToFlightsAndTicketTypesPage();
        passengersPage = farePage.acceptFare();
        extrasPage = passengersPage.goToTravelExtrasPage();
        Assert.assertTrue(extrasPage.checkSummaryPrice(farePage.getDeparturePrice(), farePage.getReturnPrice()));
    }

    @Test
    public void childTicketIs25PercentLessThanAdult() {
        Assert.assertTrue(startPage
                .goToBookAFlightForm()
                .fillBookAndFlightForm(originAirport,destinationAirport,departureDateDelta,returnDateDelta)
                .addChild()
                .goToFlightsAndTicketTypesPage()
                .checkFareCondition(), "The condition about child fare towards adult fare is't conformed!");
    }
}

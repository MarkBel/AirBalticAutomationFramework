package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.*;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Katerina_Karpenia on 3/1/2017.
 */
public class CheckTermsAndConditions extends PageTest {

    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");

    private LoginPage loginPage;
    private BookAFlightForm bookAFlightForm;
    private PassengersPage passengersPage;
    private TravelExtrasPage travelExtrasPage;

    @BeforeClass
    public void loginTest() {

        loginPage = new LoginPage(driver);
        loginPage.login(USER_NAME, USER_PASSWORD);

    }

    @Test
    public void checkTermsAndConditionsTest () throws InterruptedException {

        Thread.sleep(2000);

        bookAFlightForm = new BookAFlightForm(driver);
        bookAFlightForm.choseCountryFrom();
        bookAFlightForm.choseCountryTo();
        bookAFlightForm.pressFindFlightsButton();
        bookAFlightForm.setDepartureDate();
        bookAFlightForm.setReturnDate();
        bookAFlightForm.goToFlightsAndTicketTypesPage();

        Thread.sleep(10000);
        FlightsAndTicketTypesPage farePage = new FlightsAndTicketTypesPage(driver);
        farePage.goToPassengersPage();

        Thread.sleep(10000);
        passengersPage = new PassengersPage(driver);
        passengersPage.goToTravelExtrasPage();

        Thread.sleep(10000);
        travelExtrasPage = new TravelExtrasPage(driver);
        travelExtrasPage.seatMeAnywhere();
        Thread.sleep(10000);
        travelExtrasPage.goToSummaryPage();

        SummaryPage summaryPage = new SummaryPage(driver);
        Thread.sleep(10000);
        summaryPage.choosePaymentMethod();


    }

}

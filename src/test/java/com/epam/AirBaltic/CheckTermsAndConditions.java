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

    private BookAFlightForm bookAFlightForm;
    private FlightsAndTicketTypesPage farePage;
    private PassengersPage passengersPage;
    private TravelExtrasPage travelExtrasPage;
    private SummaryPage summaryPage;

    @Test
    public void checkTermsAndConditionsTest () throws InterruptedException {

        startPage.loginCheck(USER_NAME, USER_PASSWORD);

        bookAFlightForm = new BookAFlightForm(driver);
        bookAFlightForm.fillBookAndFlightForm();

        farePage = new FlightsAndTicketTypesPage(driver);
        farePage.goToPassengersPage();

        passengersPage = new PassengersPage(driver);
        passengersPage.goToTravelExstrasPage();

        Thread.sleep(10000);
        travelExtrasPage = new TravelExtrasPage(driver);
        travelExtrasPage.goToSummaryPage();

        summaryPage = new SummaryPage(driver);
        Thread.sleep(10000);
        summaryPage.choosePaymentMethod();

        Assert.assertTrue(summaryPage.checkTermsAndConditions());

    }

    //Variant 2, but not finished

    @Test
    public void checkTermsTest (){

        startPage.loginCheck(USER_NAME, USER_PASSWORD);

        Assert.assertTrue(new StartPage(driver)
                .goToBookAFlightForm()
                .fillBookAndFlightForm()
                .goToPassengersPage()
                .goToTravelExtrasPage()
                .goToSummaryPage()
                .choosePaymentMethod()
                .checkTermsAndConditions()

        );

    }

}

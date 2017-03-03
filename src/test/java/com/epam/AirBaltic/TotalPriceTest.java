package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.FlightsAndTicketTypesPage;
import com.epam.AirBaltic.pages.LoginPage;
import com.epam.AirBaltic.pages.RigaBerlinFlightPage;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.annotations.Test;

public class TotalPriceTest extends PageTest {

    private final PropertyLoader properties = new PropertyLoader();

    @Test
    public void startTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(properties.getProperty("user.name"), properties.getProperty("user.password"));
        RigaBerlinFlightPage flightPage = new RigaBerlinFlightPage(driver);
        flightPage.fillFields();
        FlightsAndTicketTypesPage farePage = new FlightsAndTicketTypesPage(driver);
        farePage.acceptFare();
    }
}

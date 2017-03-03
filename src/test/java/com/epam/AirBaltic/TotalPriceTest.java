package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.FlightsAndTicketTypesPage;
import com.epam.AirBaltic.pages.LoginForm;
import com.epam.AirBaltic.pages.RigaBerlinFlightPage;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.annotations.Test;

public class TotalPriceTest extends PageTest {

    private final PropertyLoader properties = new PropertyLoader();

    @Test
    public void startTest(){
        LoginForm loginForm = new LoginForm(driver);
        loginForm.login(properties.getProperty("user.name"), properties.getProperty("user.password"));
        RigaBerlinFlightPage flightPage = new RigaBerlinFlightPage(driver);
        flightPage.fillFields();
        FlightsAndTicketTypesPage farePage = new FlightsAndTicketTypesPage(driver);
        farePage.acceptFare();
    }
}

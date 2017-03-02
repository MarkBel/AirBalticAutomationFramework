package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.BookAFlightForm;
import com.epam.AirBaltic.pages.LoginPage;
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




    }

}

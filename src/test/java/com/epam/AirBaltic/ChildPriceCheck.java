package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.BookAFlightForm;
import com.epam.AirBaltic.pages.FlightsAndTicketTypesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class ChildPriceCheck extends PageTest{

  private BookAFlightForm bookAFlightForm;
  private FlightsAndTicketTypesPage flightsAndTicketTypesPage;

    @Test
    public void ChildPriceTest(){
    bookAFlightForm = startPage.goToBookAFlightForm();
    bookAFlightForm.choseCountryFrom();
    bookAFlightForm.choseCountryTo();
    bookAFlightForm.pressFindFlightsButton();
    bookAFlightForm.setDepartureDate();
    bookAFlightForm.setReturnDate();
    bookAFlightForm.addChild();
    flightsAndTicketTypesPage = bookAFlightForm.goToFlightsAndTicketTypesPage();
    Assert.assertTrue(flightsAndTicketTypesPage.CheckFareCondition(), "The condition about child fare towards adult fare is,t conformed!");

    }
}

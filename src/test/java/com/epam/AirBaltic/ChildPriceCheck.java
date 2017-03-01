package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.BookAFlightForm;
import com.epam.AirBaltic.pages.StartPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 3/1/2017.
 */
public class ChildPriceCheck extends PageTest{

  private BookAFlightForm bookAFlightForm;

    @Test
    public void ChildPriceTest(){
    bookAFlightForm = startPage.goToBookAFlightForm();
    bookAFlightForm.choseCountryFrom();
    bookAFlightForm.choseCountryTo();
    bookAFlightForm.pressFindFlightsButton();
    bookAFlightForm.setDepartureDate();
    bookAFlightForm.setReturnDate();
    bookAFlightForm.addChild();

    }
}

package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.RigaBerlinFlightPage;
import org.testng.annotations.Test;

/**
 * Created by Dmitryi_Paulioz on 3/1/2017.
 */
public class TotalPriceTest extends PageTest {

    @Test
    public void startTest(){
        RigaBerlinFlightPage flightPage = new RigaBerlinFlightPage(driver);
        flightPage.fillFields();
    }
}

package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.SunnyDestinationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SunnyDestinationPageTest extends PreparationSteps {

    protected SunnyDestinationPage sunnyDestinationPage = null;

    @BeforeMethod
    public void jumpToSunnyDestinationPage() {
        sunnyDestinationPage = this.startPage.clickSunnyDestinationLink();
    }

    @Test
    public void sortOffersByPriceTest() {
        sunnyDestinationPage.sortOffersByPrice();
//        snowyPeaksPage.scrollToPriceTable();
//        snowyPeaksPage.getScreenShot();
        Assert.assertTrue(sunnyDestinationPage.isOffersSortedCorrectly());
    }
}

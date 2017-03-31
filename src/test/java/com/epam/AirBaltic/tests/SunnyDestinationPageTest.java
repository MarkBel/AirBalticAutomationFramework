package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.SnowyPeaksPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SunnyDestinationPageTest extends PreparationSteps {

    protected SnowyPeaksPage snowyPeaksPage = null;

    @BeforeMethod
    public void jumpToSunnyDestinationPage() {
        snowyPeaksPage = this.startPage.clickSunnyDestinationLink();
    }

    @Test
    public void sortOffersByPriceTest() {
        snowyPeaksPage.sortOffersByPrice();
//        snowyPeaksPage.scrollToPriceTable();
//        snowyPeaksPage.getScreenShot();
        Assert.assertTrue(snowyPeaksPage.isOffersSortedCorrectly());
    }
}

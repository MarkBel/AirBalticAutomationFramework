package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.SnowyPeaksPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SnowyPeaksPageTest extends AbstractPageTest {

    protected SnowyPeaksPage snowyPeaksPage = null;

    @BeforeClass
    public void jumpToSnowyPeaksPage() {
        snowyPeaksPage = this.startPage.clickFlySnowyPeaksLink();
    }

    @Test
    public void testSortOffersByPriceTest() {
        snowyPeaksPage.sortOffersByPrice();
//        snowyPeaksPage.scrollToPriceTable();
        snowyPeaksPage.getScreenShot();
        Assert.assertTrue(snowyPeaksPage.isOffersSortedCorrectly());
    }
}

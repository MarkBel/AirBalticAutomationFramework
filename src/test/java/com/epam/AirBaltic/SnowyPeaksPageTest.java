package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.SnowyPeaksPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SnowyPeaksPageTest extends AbstractPageTest {

    protected SnowyPeaksPage snowyPeaksPage = null;

    @BeforeClass
    public void jumpToSnowyPeaksPage() {
        //logger.info("Attempt to open SnowyPeaksPage");
        snowyPeaksPage = this.startPage.clickFlySnowyPeaksLink();
        //logger.info("Page SnowyPeaksPage opened");
    }

    @Test
    public void testSortOffersByPriceTest() {
        snowyPeaksPage.sortOffersByPrice();
        Assert.assertTrue(snowyPeaksPage.isOffersSortedCorrectly());
    }
}

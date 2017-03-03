package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.YouthOfferPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YouthOfferPageTest extends PageTest {

    protected YouthOfferPage youthOfferPage = null;

    @BeforeClass
    public void jumpToYouthOfferPage() {
        //logger.info("Attempt to open Create new repository page");
        youthOfferPage = this.startPage.gotoYouthOfferPageByLink();
        //logger.info("Page YouthOfferPage opened");
    }

    @Test(dataProvider="citiesList")
    public void testOffersListCorrectlyShown(String cityName) {
        //String cityName = "Riga";
        //logger.info("setting origin city in menu as " + cityName);
        youthOfferPage.setOriginCity(cityName);
        cityName = youthOfferPage.getSelectedOriginCity();
        //logger.info("origin city in menu - " + cityName);
        //logger.info("Number of offers from " + cityName + " is " + youthOfferPage.getOffersNumberFromCurrentCity());
        Assert.assertTrue(youthOfferPage.isOriginsShownCorrectly());
    }

    @AfterMethod
    public void clearOriginInput() {
        youthOfferPage.clearOriginCity();
    }


    @DataProvider(name = "citiesList")
    public static Object[][] citiesList() {
        return new Object[][]{
                {"Riga"},
                {"Tallinn"},
                {"Vilnius"}};

    }
}

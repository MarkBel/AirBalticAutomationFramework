package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.pages.YouthOfferPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YouthOfferPageTest extends AbstractPageTest {

    protected YouthOfferPage youthOfferPage = null;

    @BeforeClass
    public void jumpToYouthOfferPage() {
        youthOfferPage = this.startPage.gotoYouthOfferPageByLink();
    }

    @Test(dataProvider="citiesList")
    public void testOffersListCorrectlyShown(String cityName, boolean expectedResult) {
        youthOfferPage.setOriginCity(cityName);
        Assert.assertEquals(youthOfferPage.isOriginsShownCorrectly(), expectedResult);
    }

    @AfterMethod
    public void clearOriginInput() {
        youthOfferPage.clearOriginCity();
    }


    @DataProvider(name = "citiesList")
    public static Object[][] citiesList() {
        return new Object[][]{
                {"Riga", true},
                {"Tallinn", true},
                {"Vilnius", true},
                {"New-Vasuki", false},
                {"Berlin",false},
                {"Montevideo", false}};

    }
}

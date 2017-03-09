package com.epam.AirBaltic;

import com.epam.AirBaltic.pages.LoginForm;
import com.epam.AirBaltic.pages.YouthOfferPage;
import com.epam.AirBaltic.util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YouthOfferPageTest extends AbstractPageTest {

    protected YouthOfferPage youthOfferPage = null;

    @BeforeClass
    public void jumpToYouthOfferPage() {
//        if (!this.startPage.isLoggedIn()) {
//           this.startPage.loginFromStartPage();
//        }
        youthOfferPage = this.startPage.gotoYouthOfferPageByLink();
        //logger.info("Page YouthOfferPage opened");
    }

    @Test(dataProvider="citiesList")
    public void testOffersListCorrectlyShown(String cityName, boolean expectedResult) {
        //logger.info("setting origin city in menu as " + cityName);
        youthOfferPage.setOriginCity(cityName);
        cityName = youthOfferPage.getSelectedOriginCity();
        //logger.info("origin city in menu - " + cityName);
        //logger.info("Number of offers from " + cityName + " is " + youthOfferPage.getOffersNumberFromCurrentCity());
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

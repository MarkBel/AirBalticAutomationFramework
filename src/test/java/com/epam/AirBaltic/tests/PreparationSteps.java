package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.driver.DriverSingleton;
import com.epam.AirBaltic.pages.StartPage;
import com.epam.AirBaltic.util.PropertyLoader;
import com.epam.AirBaltic.util.SessionHelper;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.IOException;

public class PreparationSteps {

    protected static final String START_PAGE_URL = PropertyLoader.getProperty("start.url");
    protected static DesiredCapabilities capabilities;
    protected StartPage startPage;
    protected WebDriver driver;

    protected static final String NEW_SURNAME = PropertyLoader.getProperty("editProfilePage.newSurname");
    protected static final String USER_NAME = PropertyLoader.getProperty("user.name");
    protected static final String USER_PASSWORD = PropertyLoader.getProperty("user.password");
    protected static final String ORIGIN_AIRPORT = "Riga (RIX) - Latvia";
    protected static final String DESTINATION_AIRPORT = "Berlin (Tegel) (TXL) - Germany";
    protected static final int DEPARTURE_DATE_DELTA = 2;
    protected static final int RETURN_DATE_DELTA = 5;
    protected static final int RETURN_UNVALID_DATE_DELTA = -5;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        String browserName = SessionHelper.selectBrowser();
        if ((capabilities = SessionHelper.getBrowserCaps(browserName.toLowerCase())) == null) {
            throw new NoSuchSessionException("Required parameters can't be set");
        }
    }

    @BeforeMethod
    public void initWebDriver() throws InterruptedException {
        driver = DriverSingleton.getDriver(capabilities);
        System.out.println("Switch-over to PreparationSteps after running webdriver");
        driver.navigate().to(START_PAGE_URL);
        System.out.println("Passed to start URL ");
        startPage = new StartPage(driver);
        System.out.println(startPage.getTitle());
    //    startPage.getScreenShot();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}

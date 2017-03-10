package com.epam.AirBaltic.tests;

import com.epam.AirBaltic.driver.MutatedSingleton;
import com.epam.AirBaltic.pages.StartPage;
import com.epam.AirBaltic.util.PropertyLoader;
import com.epam.AirBaltic.util.SessionHelper;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class PreparationSteps {

    protected static final String START_PAGE_URL = PropertyLoader.getProperty("start.url");
    protected static DesiredCapabilities capabilities;
    protected StartPage startPage = null;
    protected WebDriver driver;

    protected String originAirport = "Riga (RIX) - Latvia";
    protected String destinationAirport = "Berlin (Tegel) (TXL) - Germany";
    protected static final String ERROR_MESSAGE = "The date of the inbound flight cannot be earlier than the date of the outbound flight. Please adjust your selection.";
    protected static final String RETURN_DATE_ATTRIBUTE = "display: none;";
    protected static final String ERROR_INPUT_EXCEPTION = "The number of infants can not be higher than the number of adults. Only an adult can accompany an infant.";
    protected int departureDateDelta = 2;
    protected int returnDateDelta = 5;
    protected int returnUnvalidDateDelta = -5;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        String browserName = SessionHelper.selectBrowser();
        if ((capabilities = SessionHelper.getBrowserCaps(browserName.toLowerCase())) == null) {
            throw new NoSuchSessionException("Required parameters can't be set");
        }
    }

    @BeforeClass
    public void initWebDriver() throws InterruptedException {
        driver = MutatedSingleton.getDriver(capabilities);
        driver.navigate().to(START_PAGE_URL);
        startPage = new StartPage(driver);
    }

    @AfterClass
    public void tearDown() {
        MutatedSingleton.closeDriver();
    }
}

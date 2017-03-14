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
    protected static final String originAirport = "Riga (RIX) - Latvia";
    protected static final String destinationAirport = "Berlin (Tegel) (TXL) - Germany";
    protected static final int departureDateDelta = 2;
    protected static final int returnDateDelta = 5;
    protected static final int returnUnvalidDateDelta = -5;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        String browserName = SessionHelper.selectBrowser();
        if ((capabilities = SessionHelper.getBrowserCaps(browserName.toLowerCase())) == null) {
            throw new NoSuchSessionException("Required parameters can't be set");
        }
    }

    @BeforeMethod
    public void initWebDriver() throws InterruptedException {
        System.out.println(capabilities.toString());
        System.out.println("Path to ChromeDriver - " + PropertyLoader.getProperty("chromedriver.win.path"));
        System.out.println("Path to GeckoDriver - " + PropertyLoader.getProperty("geckodriver.win.path"));
        System.out.println("URL of StartPage is - " + PropertyLoader.getProperty("start.url"));
        driver = DriverSingleton.getDriver(capabilities);
        driver.navigate().to(START_PAGE_URL);
        startPage = new StartPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}

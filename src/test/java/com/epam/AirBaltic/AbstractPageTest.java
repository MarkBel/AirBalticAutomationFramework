package com.epam.AirBaltic;

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

public class AbstractPageTest {

    protected static final String START_PAGE_URL = PropertyLoader.getProperty("start.url");
    protected static DesiredCapabilities capabilities;
    protected StartPage startPage = null;
    protected WebDriver driver;

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

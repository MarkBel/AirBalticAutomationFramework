package com.epam.AirBaltic;

import com.epam.AirBaltic.driver.MutatedSingleton;
import com.epam.AirBaltic.pages.StartPage;
import com.epam.AirBaltic.util.PropertyLoader;
import com.epam.AirBaltic.util.SessionHelper;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

/**
 * Base class for TestNG-based test classes
 */
public class PageTest {

  protected static final String START_PAGE_URL = PropertyLoader.getProperty("start.url");
  protected static DesiredCapabilities capabilities;
  protected StartPage startPage = null;
  protected WebDriver driver;

  //Logger logger = Logger.getLogger("TestLogger");

  @BeforeSuite
  public void initTestSuite() throws IOException {
    String browserName = PropertyLoader.getProperty("browser.name");
    if ((capabilities = SessionHelper.getBrowserCaps(browserName.toLowerCase())) == null) {
      throw new NoSuchSessionException("Required parameters can't be set");
    }
  }

  @BeforeClass
  public void initWebDriver() {
    driver = MutatedSingleton.getDriver(capabilities);
    driver.manage().window().maximize();
    driver.navigate().to(START_PAGE_URL);
    startPage = new StartPage(driver);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    MutatedSingleton.cLoseAllDrivers();
  }
}
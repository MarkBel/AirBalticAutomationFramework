package com.epam.AirBaltic.tests.cucumber;

import com.epam.AirBaltic.tests.PreparationSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;

/**
 * Created by Kate on 12.06.17.
 */
public class Hooks extends PreparationSteps{

    @Before("@Scenario")
    public static void init() throws IOException, InterruptedException {
        initTestSuite();
        initWebDriver();
    }

    @After("@Scenario")
    public static void close(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        tearDown();
    }

    @Given("^I am logged in$")
    public void iAmLoggedIn () throws Throwable {
        startPage.goToLoginForm().login(USER_NAME, USER_PASSWORD).getLoginStatement();
}


}

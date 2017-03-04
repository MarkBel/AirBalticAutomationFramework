package com.epam.AirBaltic.util;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SessionHelper {
    public static DesiredCapabilities getBrowserCaps(String browser) {
        DesiredCapabilities capabilities = null;

        final String CHROMEDRIVER_WIN_PATH=PropertyLoader.getProperty("chromedriver.win.path");
        final String GECKODRIVER_WIN_PATH=PropertyLoader.getProperty("geckodriver.win.path");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_WIN_PATH);
                capabilities = DesiredCapabilities.chrome();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", GECKODRIVER_WIN_PATH);
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                capabilities.setBrowserName("firefox");
                break;
            default:
                System.out.println("Browser is not supported");
        }
        return capabilities;
    }
}

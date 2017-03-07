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

    // set JVM option -Dbrowser=chrome in Run/Debug configuration settings tu run chrome instead of firefox
    public static String selectBrowser() {
        String browserName;
        String browserFromProperty = PropertyLoader.getProperty("browser.name");
        String browserFromCommandLine = System.getProperty("browser");
            if (browserFromProperty == null && browserFromCommandLine == null) {
                browserName = "firefox";
            } else if (browserFromProperty == null) {
                browserName = browserFromCommandLine;
            } else if (browserFromCommandLine == null) {
                browserName = browserFromProperty;
            } else {
                browserName = browserFromCommandLine;
            }
        return browserName;
    }
}

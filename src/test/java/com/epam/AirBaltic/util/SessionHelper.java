package com.epam.AirBaltic.util;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

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

    public  static void captureScreenShot(WebDriver webDriver, String pageClassName) throws IOException {
        File screenShotFile=((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile,new File("screenshots\\"+ pageClassName +
                                        "--" + DateGenerator.getTimeStamp()+".png"));

    }

}

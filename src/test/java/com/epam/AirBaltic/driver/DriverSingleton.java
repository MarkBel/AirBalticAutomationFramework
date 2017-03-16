package com.epam.AirBaltic.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver webDriver;

    public static WebDriver getDriver(DesiredCapabilities cap) {
        if (webDriver == null) {
            String browserName = cap.getBrowserName();
            switch (browserName) {
                case "chrome":
                    webDriver = new ChromeDriver(cap);
                    break;
                case "firefox":
                    webDriver = new FirefoxDriver(cap);
                    break;
                default:
                    webDriver = new FirefoxDriver(cap);
                    break;
            }
        }
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Webdriver started");
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}

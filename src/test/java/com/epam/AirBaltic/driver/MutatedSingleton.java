package com.epam.AirBaltic.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class MutatedSingleton {

    private static WebDriver webDriver;

    public static WebDriver getDriver(DesiredCapabilities cap) {
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
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
